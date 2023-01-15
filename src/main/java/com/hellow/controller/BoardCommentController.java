package com.hellow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellow.service.BoardCommentService;
import com.hellow.vo.BoardCommentVO;

@Controller
public class BoardCommentController {
	@Autowired
	private BoardCommentService boardComment;
	
	@GetMapping("/board-comment/{tbNum}")
	@ResponseBody
	public List<BoardCommentVO> getBoardComment(@PathVariable int tbNum){
		return boardComment.getBoardComment(tbNum);
	}
	
	@PostMapping("/board-comment")
	@ResponseBody
	public int insertBoardComment(@RequestBody BoardCommentVO boardCommentVO) {
		return boardComment.insertBoardComment(boardCommentVO);
	}
	
}
