package com.hellow.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.google.gson.JsonObject;
import com.hellow.service.TestBoardService;
import com.hellow.vo.TestBoardVO;

@Controller
public class TestBoardController {
	@Autowired
	private TestBoardService testBoardService;
	
	@GetMapping("/test-board")
	@ResponseBody
	public List<TestBoardVO> getTestBoardList(TestBoardVO testBoard){
		return testBoardService.selectTestBoardList(testBoard);
	}
	
	@PostMapping("/test-board/insert")
	@ResponseBody
	public int insertTestBoard(@RequestBody TestBoardVO testBoard) {
		return testBoardService.insertTestBoard(testBoard);
	}
	
	@GetMapping("/test-board/{tbNum}")
	@ResponseBody
	public TestBoardVO getTestBoard(@PathVariable int tbNum) {
		return testBoardService.getTestBoard(tbNum);
	}
	
	@PatchMapping("/test-board/{tbNum}")
	@ResponseBody
	public int updateTestBoard(@RequestBody TestBoardVO testBoard, @PathVariable int tbNum) {
		testBoard.setTbNum(tbNum);
		return testBoardService.updateTestBoard(testBoard);
	}
	
	@DeleteMapping("/test-board/{tbNum}")
	@ResponseBody
	public int deleteTestBoard(@PathVariable int tbNum) {
		return testBoardService.deleteTestBoard(tbNum);
	}
	
	
	@PostMapping(value="/uploadSummernoteImageFile", produces = "application/json")
	@ResponseBody
	public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {
		
		JsonObject jsonObject = new JsonObject();
		
		String fileRoot = "D:\\work\\";	//저장될 외부 파일 경로
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
				
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	
}
