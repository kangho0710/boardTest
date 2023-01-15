package com.hellow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellow.mapper.BoardCommentMapper;
import com.hellow.vo.BoardCommentVO;

@Service
public class BoardCommentService {
	@Autowired
	private BoardCommentMapper boardComment;
	
	public List<BoardCommentVO> getBoardComment(int tbNum){
		return boardComment.getBoardComment(tbNum); 
	}
	
	public int insertBoardComment(BoardCommentVO boardCommentVO) {
		return boardComment.insertBoardComment(boardCommentVO);
	}
	
	public int updateBoardComment(BoardCommentVO boardCommentVO) {
		return boardComment.updateBoardComment(boardCommentVO);
	}
	
	public int deleteBoardComment(int tbNum) {
		return boardComment.deleteBoardComment(tbNum);
	}
}
