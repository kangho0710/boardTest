package com.hellow.mapper;

import java.util.List;

import com.hellow.vo.BoardCommentVO;

public interface BoardCommentMapper {
	List<BoardCommentVO> getBoardComment(int tbNum);
	int insertBoardComment(BoardCommentVO boardComment);
	int updateBoardComment(BoardCommentVO boardComment);
	int deleteBoardComment(int tbNum);
	
}
