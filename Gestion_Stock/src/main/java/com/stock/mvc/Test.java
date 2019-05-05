package com.stock.mvc;
import com.stock.mvc.dao.impl.FlickrDaoImpl;

public class Test {
	public static void main(String[] args) {
		FlickrDaoImpl flickr= new FlickrDaoImpl();
		flickr.auth();
	}
}
