package com.hellow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hellow.vo.TestBoardVO;

@Mapper
public interface TestBoardMapper {
	TestBoardVO selectTestBoard(int tbNum);
	List<TestBoardVO>selectTestBoardList(TestBoardVO testBoard);
	int insertTestBoard(TestBoardVO testBoard);
	int updateTestBoard(TestBoardVO testBoard);
	int deleteTestBoard(int tbNum);
}
