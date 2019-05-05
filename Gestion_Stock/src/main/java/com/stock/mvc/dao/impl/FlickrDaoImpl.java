package com.stock.mvc.dao.impl;
 

import java.io.InputStream;

import javax.swing.JOptionPane;

import org.scribe.model.Token;
import org.scribe.model.Verifier;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.stock.mvc.dao.IFlickrDao;

public class FlickrDaoImpl implements IFlickrDao{
	private Flickr flickr;
	private UploadMetaData uploadMetaData= new UploadMetaData();
	private String apiKey="fbd934011fe203251d12102361962067";
	private String sharedSecret="5f9a8095cb17b93c";
	
	private void connect() {
		flickr=new Flickr(apiKey,sharedSecret,new REST());
		Auth auth=new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("72157678731273846-45f683ca35c4b3c2");
		auth.setTokenSecret("6342826986448e45");
		RequestContext requestContext= RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
	}

	@Override
	public String savePhoto(InputStream photo, String title) throws Exception{
		// TODO Auto-generated method stub
		connect();
		uploadMetaData.setTitle(title);
		String photoId=flickr.getUploader().upload(photo, uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	
	}
	
	public void auth() {
		flickr=new Flickr(apiKey,sharedSecret,new REST());
		AuthInterface authInterface=flickr.getAuthInterface();
		Token token= authInterface.getRequestToken();
		System.out.println("token: "+token);
		String url=authInterface.getAuthorizationUrl(token, Permission.DELETE);
		System.out.println("follow this URL to authorize yourself on Flickr");
		System.out.println(url);
		
		System.out.println("Paste in the token it gives you:");
		System.out.println(">>");
		
		String tokenKey=JOptionPane.showInputDialog(null);
		Token requestToken= authInterface.getAccessToken(token,new Verifier(tokenKey));
		System.out.println("Authentification success");
		
		Auth auth=null;
		try {
			auth=authInterface.checkToken(requestToken);
		}catch(FlickrException e){
			e.printStackTrace();
		}
		
		//this token can be used until the user revokes it
		System.out.println("Token: "+requestToken.getToken());
		System.out.println("Secret: "+requestToken.getSecret());
		System.out.println("nsId: "+auth.getUser().getId());
		System.out.println("Realname: "+auth.getUser().getRealName());
		System.out.println("Username: "+auth.getUser().getUsername());
		System.out.println("Permission: "+auth.getPermission().getType());
		
	}
	
}
