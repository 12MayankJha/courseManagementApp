package com.springRest.springRest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.springRest.springRest.entities.DatabaseFile;
import com.springRest.springRest.payload.ImageUploadResponse;
import com.springRest.springRest.services.DatabaseFileService;

@RestController
public class ImageController {

	@Autowired
	private DatabaseFileService fileStorageService;

	@PostMapping("/uploadFile")
	public ImageUploadResponse uploadFile(@RequestParam("file") MultipartFile file) {

		DatabaseFile fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName.getId()).toUriString();

		return new ImageUploadResponse(fileName.getFileName(), fileDownloadUri, file.getContentType(), file.getSize(),
				fileName.getId());
	}

	@PostMapping("/uploadMultipleFiles")
	public List<ImageUploadResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files)
				.stream()
				.map(file -> uploadFile(file))
				.collect(Collectors.toList());
	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId, HttpServletRequest request) {
		// Load file as Resource
		DatabaseFile databaseFile = fileStorageService.getFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(databaseFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + databaseFile.getFileName() + "\"")
				.body(new ByteArrayResource(databaseFile.getData()));
	}

}