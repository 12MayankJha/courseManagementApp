package com.springRest.springRest.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springRest.springRest.dao.DatabaseFileRepository;
import com.springRest.springRest.entities.DatabaseFile;
import com.springRest.springRest.exceptions.FileNotFoundException;
import com.springRest.springRest.exceptions.FileStorageException;
import com.springRest.springRest.payload.ImageUploadResponse;
import com.springRest.springRest.payload.ImageDataResponse;

@Service
public class DatabaseFileServiceImpl implements DatabaseFileService {

	@Autowired
	private DatabaseFileRepository dbFileRepository;

	@Override
	public DatabaseFile storeFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

			return dbFileRepository.save(dbFile);
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	@Override
	public DatabaseFile getFile(String fileId) {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
	}
	
	@Override
	public List<ImageDataResponse> getAllImageData() {
		
		List<DatabaseFile> list =  dbFileRepository.findAll();
		
		List<ImageDataResponse> imageList = new ArrayList<ImageDataResponse>();
		
		for(DatabaseFile file: list) {
		        imageList.add( new ImageDataResponse(file.getId(), file.getFileName()));
		}
		
		return imageList;
	}

}
