package com.lealtad360.panelscotiacms.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lealtad360.panelscotiacms.entity.services.FileUploadService;

@RestController
public class FileUploadController{
@Autowired
FileUploadService fileuploadservice;
	
	@PostMapping("/destacados/{periodo}")
	public void uploadFile(@RequestParam("file") MultipartFile file, @PathVariable(value = "periodo") String periodo ) throws IllegalStateException, IOException {
		fileuploadservice.uploadFile(file, periodo);
	}
	
	
}