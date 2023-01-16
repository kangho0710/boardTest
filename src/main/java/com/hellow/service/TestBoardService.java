package com.hellow.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.hellow.mapper.TestBoardMapper;
import com.hellow.vo.TestBoardVO;

@Service
public class TestBoardService {
	@Autowired
	private TestBoardMapper testBoardMapper;
	
	public List<TestBoardVO> selectTestBoardList(TestBoardVO testBoard){
		return testBoardMapper.selectTestBoardList(testBoard);
	}
	
	public int insertTestBoard(TestBoardVO testBoard) {
		return testBoardMapper.insertTestBoard(testBoard);
	}
	
	public TestBoardVO getTestBoard(int tbNum) {
		testBoardMapper.cntTestBoard(tbNum);
		return testBoardMapper.selectTestBoard(tbNum);
	}
	
	public int updateTestBoard(TestBoardVO testBoard) {
		return testBoardMapper.updateTestBoard(testBoard);
	}
	
	public int deleteTestBoard(int tbNum) {
		return testBoardMapper.deleteTestBoard(tbNum);
	}
	
	public int count() {
		return testBoardMapper.count();
	}
	
	public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {
		JsonObject jsonObject = new JsonObject();

		String fileRoot = "C:\\java-work\\"; // 저장될 외부 파일 경로
		String originalFileName = multipartFile.getOriginalFilename(); // 오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자

		String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명

		File targetFile = new File(fileRoot + savedFileName);

		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile); // 파일 저장
			jsonObject.addProperty("url", "/summernoteImage/" + savedFileName);
			jsonObject.addProperty("responseCode", "success");

		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile); // 저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}

		return jsonObject;
	}
	
}
