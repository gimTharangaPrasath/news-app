package com.aeturnum.newsapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.aeturnum.newsapp.domain.NewsResponseDTO;
import com.aeturnum.newsapp.repository.NewsRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NewsServiceImpl implements NewsService{
	
	private Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public NewsResponseDTO importNews() {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		String url = "https://newsapi.org/v2/everything?q=bitcoin&from=2019-03-14&sortBy=publishedAt&apiKey=4e50eb498a1d498f878bbf5e858f439c";
		
		ResponseEntity<String> response = null;
		
		try {
			response = restTemplate.exchange(url, HttpMethod.GET, request, String.class );
			
			
		}catch(RestClientException e) {
			
			logger.info(e.getMessage());
			
		}
		
		return (response != null) ? convertJSONToObject(response, NewsResponseDTO.class ): null;
		
	}
	@Override
	public void saveNews(NewsResponseDTO newsResponseDTO) {
		newsRepository.save(newsResponseDTO);
	}
	
	private <T> T convertJSONToObject(ResponseEntity<String> response, Class<T> responseType) {
		
		T t = null;

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {

			t = objectMapper.readValue(response.getBody().toString(), responseType);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return t;
	}

}
