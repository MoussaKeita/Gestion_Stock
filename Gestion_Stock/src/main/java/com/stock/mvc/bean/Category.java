package com.stock.mvc.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id_Category")
    private Long id;
    
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
    private String code;
    private String libelle;

     public Category() {
	
      }

	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


	public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public List<Article> getArticles() {
		return articles;
	}


	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
	
}
