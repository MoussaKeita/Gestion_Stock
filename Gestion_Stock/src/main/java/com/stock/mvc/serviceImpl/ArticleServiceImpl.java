package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.Article;
import com.stock.mvc.dao.ArticleDao;
import com.stock.mvc.service.ArticleService;

@Transactional
public class ArticleServiceImpl implements ArticleService {
	private ArticleDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public ArticleDao getDao() {
		return dao;
	}

	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Article save(Article entity) {
		return dao.save(entity);
	}


	@Override
	public Article update(Article entity) {
		return dao.update(entity);
	}

	@Override
	public List<Article> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Article> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Article findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Article findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public Article getbyCode(String code) {
	 return dao.getbyCode(code);
	}

	@Override
	public void remove(String code) {
		 dao.remove(code);
	}

	@Override
	public Article getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}
}
