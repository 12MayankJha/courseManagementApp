package com.springRest.springRest.services;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.springRest.springRest.entities.DatabaseFile;
import com.springRest.springRest.payload.ImageDataResponse;

public interface DatabaseFileService {

	DatabaseFile getFile(String fileId);

	DatabaseFile storeFile(MultipartFile file, Boolean isPopular, String category, String name, String price);
	
	Map<String, List<ImageDataResponse>> getAllImageData();

	Map<String, List<ImageDataResponse>> getAllPopularImageData();
	
}
