package com.springRest.springRest.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springRest.springRest.Helper.ImageHelper;
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
	public DatabaseFile storeFile(MultipartFile file, Boolean isPopular, String category) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), isPopular, category, file.getBytes());
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
	public Map<String,List<ImageDataResponse>> getAllImageData() {
		
		Map<String,List<ImageDataResponse>> imageMap = new HashMap<String, List<ImageDataResponse>>();
		
		for(String category: ImageHelper.CATEGORIES) {
			List<DatabaseFile> imagefile = dbFileRepository.findByCategory(category);
			List<ImageDataResponse> imageList = new  ArrayList<ImageDataResponse>();
			for(DatabaseFile selectedFile: imagefile) {
				String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
						.path(selectedFile.getId()).toUriString();
				imageList.add(new ImageDataResponse(selectedFile.getId(), fileDownloadUri));
			}
			
			imageMap.put(category, imageList);
		}
		
		return imageMap;
	}

	@Override
	public Map<String, List<ImageDataResponse>> getAllPopularImageData() {
		Map<String, List<ImageDataResponse>> imageMap = new HashMap<String, List<ImageDataResponse>>();

		for (String category : ImageHelper.CATEGORIES) {
			List<DatabaseFile> imagefile = dbFileRepository.findByCategory(category);
			List<ImageDataResponse> imageList = new ArrayList<ImageDataResponse>();
			for (DatabaseFile selectedFile : imagefile) {
				if (selectedFile.getIsPopular()) {
					String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
							.path(selectedFile.getId()).toUriString();
					imageList.add(new ImageDataResponse(selectedFile.getId(), fileDownloadUri));
				}
			}

			imageMap.put(category, imageList);
		}

		return imageMap;
	}
	

}
