package com.springRest.springRest.services;

import org.springframework.web.multipart.MultipartFile;

import com.springRest.springRest.entities.DatabaseFile;

public interface DatabaseFileService {

	DatabaseFile getFile(String fileId);

	DatabaseFile storeFile(MultipartFile file);

}
