package com.springRest.springRest.entities;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "files")
public class DatabaseFile {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String fileName;

	private String fileType;
	
	private Boolean isPopular;
	
	private String category;
	
	private String name;
	
	private String price;
	
	@Lob
	//@Type(type = "org.hibernate.type.ImageType")
	private byte[] data;

	public DatabaseFile() {
		super();
	}


	public DatabaseFile(String fileName, String fileType, Boolean isPopular, String category, byte[] data, String name,
			String price) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.isPopular = isPopular;
		this.category = category;
		this.data = data;
		this.name = name;
		this.price = price;
	}


	public String getId() {
		return id;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public void setData(byte[] data) {
		this.data = data;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public Boolean getIsPopular() {
		return isPopular;
	}


	public void setIsPopular(Boolean isPopular) {
		this.isPopular = isPopular;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}

}
