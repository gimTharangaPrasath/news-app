package com.aeturnum.newsapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aeturnum.newsapp.domain.NewsResponseDTO;

@Repository
public interface NewsRepository extends MongoRepository<NewsResponseDTO, String>{

}
