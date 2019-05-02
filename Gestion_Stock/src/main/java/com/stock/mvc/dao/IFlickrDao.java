package com.stock.mvc.dao;

import java.io.InputStream;

public interface IFlickrDao {
	public String savePhoto(InputStream strem, String fileName) throws Exception;
	//public String savePhoto(InputStream strem, String fileName) ;

}
