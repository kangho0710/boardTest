package com.hellow.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
	@PostMapping("/files-upload")
	public String fileUpload(@RequestPart("file") MultipartFile mf) throws IllegalStateException, IOException {
		
		String path = "C:/java-work/upload/" + mf.getOriginalFilename();
		File tmpFile = new File(path);
		mf.transferTo(tmpFile);
		return mf.getOriginalFilename();
	}
}
