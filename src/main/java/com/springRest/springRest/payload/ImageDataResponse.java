package com.springRest.springRest.payload;

public class ImageDataResponse {
	
	private String id;
	private String fileName;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public ImageDataResponse(String id, String fileName) {
		super();
		this.id = id;
		this.fileName = fileName;
	}
	
	

}