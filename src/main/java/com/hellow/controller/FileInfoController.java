package com.hellow.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellow.service.FileInfoService;
import com.hellow.vo.FileInfoVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FileInfoController {
	@Autowired
	private FileInfoService fileInfoService;
	@PostMapping("/file-infos")
	public int fileUpload(@ModelAttribute FileInfoVO fileInfo) throws IllegalStateException, IOException {
		int result = fileInfoService.insertFileInfo(fileInfo);
		return result;
	}
	
}
