package com.lealtad360.panelscotiacms.entity.services;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	void init();
	void store(MultipartFile File);
	Stream<Path> loadAll();
	
	Path load(String filename);
	Resource loadAsResource(String filename);
	void deleteAll();

}
