package com.firstjava.bookrestapi.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.validation.constraints.NotNull;

import com.sun.istack.NotNull;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String title;
	
	@NotNull
	private String author;
	@NotNull
	private String coverPhotoURl;
	
	@NotNull
	private String lnguage;;
	
	
	public Long getId()
	{
		return id;

	}

	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return author;
	}
	
	public String getCoverPhotoURl()
	{
		return coverPhotoURl;
	}
//	
	public String getlnguage()
	{
		return lnguage;
	}

	public void setTitle(String myTitle) {
		
		this.title = myTitle;
	}

	public void setAuthor(String myAuthor) {
		// TODO Auto-generated method stub
		this.author = myAuthor;
		
	}

	public void setLanguage(String myLanguage) {
		// TODO Auto-generated method stub
		
		this.lnguage = myLanguage;
		
	}

	public void setCoverPhotoUrl(String myUrl) {
		// TODO Auto-generated method stub
		this.coverPhotoURl = myUrl;
		
	}





}
