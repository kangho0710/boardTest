package com.hellow.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileInfoVO {
	private int fileNum;
	private String fiName;
	private String fiPath;
	private String fiContent;
	private MultipartFile file;
}
