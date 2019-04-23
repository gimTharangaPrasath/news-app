package com.aeturnum.newsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aeturnum.newsapp.domain.NewsResponseDTO;
import com.aeturnum.newsapp.service.NewsService;

@RestController
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@RequestMapping(value = "/getNews", method = RequestMethod.GET)
	@ResponseBody
	public void getAllNews(NewsResponseDTO newsResponseDTO) {
		
		newsService.importNews();
		
		newsService.saveNews(newsResponseDTO);
		
	}

}
