package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.Article;

public interface ArticleService{
	public Article save(Article entity);
	public Article update(Article entity);
	public List<Article> selectAll();
	public List<Article> selectAll(String sortField, String sort);
	public Article getbyId(Long id);
	public void remove(Long id);
	public Article getbyCode(String code);
	public void remove(String code);
	public Article findOne(String paramName, Object paramValue);
	public Article findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}
