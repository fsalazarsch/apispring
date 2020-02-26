package com.lealtad360.panelscotiacms.entity.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Service
public class FileUploadService  {
	
	//public String rutaServer ="/var/www/html/storage.lealtad360.com/panelscotia/2020_01/";
	public String rutaServer ="C:\\laragon\\www\\uploads\\";
	
	
	
	public void uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(new File(rutaServer+file.getOriginalFilename()));
		
	}
	

}