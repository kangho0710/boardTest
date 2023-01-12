package com.hellow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
