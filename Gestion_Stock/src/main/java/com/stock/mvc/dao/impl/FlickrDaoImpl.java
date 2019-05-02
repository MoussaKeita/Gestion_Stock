package com.stock.mvc.dao.impl;

import java.io.InputStream;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.stock.mvc.dao.IFlickrDao;

public class FlickrDaoImpl implements IFlickrDao{
	
	private Flickr flickr;
	private UploadMetaData uploadMetaData= new UploadMetaData();
/*
	@Override
	public String savePhoto(InputStream photo, String title) throws Exception{
		uploadMetaData.setTitle(title);
		String photoId=flickr.getUploader().upload(photo, uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	
	}
	*/
	@Override
	public String savePhoto(InputStream photo, String title) throws Exception {
		uploadMetaData.setTitle(title);
		String photoId=flickr.getUploader().upload(photo, uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	
	}
}
