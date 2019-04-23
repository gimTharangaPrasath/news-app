package com.aeturnum.newsapp.service;

import org.springframework.stereotype.Service;
import com.aeturnum.newsapp.domain.NewsResponseDTO;

@Service
public interface NewsService {
	

 public NewsResponseDTO importNews();
 
 public void saveNews(NewsResponseDTO newsResponseDTO);

}
