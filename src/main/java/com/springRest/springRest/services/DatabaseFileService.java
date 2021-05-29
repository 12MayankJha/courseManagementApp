package com.springRest.springRest.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springRest.springRest.entities.DatabaseFile;
import com.springRest.springRest.payload.ImageDataResponse;

public interface DatabaseFileService {

	DatabaseFile getFile(String fileId);

	DatabaseFile storeFile(MultipartFile file);
	
	public List<ImageDataResponse> getAllImageData();

}
