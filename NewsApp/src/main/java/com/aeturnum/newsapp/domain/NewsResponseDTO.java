package com.aeturnum.newsapp.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NewsResponseDTO {
	
	private String status;
	private int totalResults;
	private List<Articals> articles;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	public List<Articals> getArticles() {
		return articles;
	}
	public void setArticles(List<Articals> articles) {
		this.articles = articles;
	}
	
}
