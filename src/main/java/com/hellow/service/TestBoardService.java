package com.hellow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
