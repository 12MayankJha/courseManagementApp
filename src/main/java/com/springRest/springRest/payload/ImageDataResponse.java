package com.springRest.springRest.payload;

public class ImageDataResponse {

	private String id;
	private String imageURL;

	public ImageDataResponse(String id, String imageURL) {
		super();
		this.id = id;
		this.imageURL = imageURL;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

}
