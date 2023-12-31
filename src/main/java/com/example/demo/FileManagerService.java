package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {
	public static final String FILE_UPLOAD_PATH = "D:\\정재우\\6_real Project\\workspace\\images/";
	
	public String saveFile(String loginId, MultipartFile file) {
		String directoryName = loginId +"_" + System.currentTimeMillis();
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		
		if(directory.mkdir() == false) {
			return null;
		}
		
		try {
			byte[] bytes;
			bytes = file.getBytes();
			
			Path path = Paths.get(filePath + "/" + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
		return "/images/" + directoryName + "/" + file.getOriginalFilename();
		
	}
}
