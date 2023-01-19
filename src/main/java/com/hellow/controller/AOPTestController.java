package com.hellow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellow.anno.CheckAuth;
import com.hellow.vo.UserInfoVO;

@Controller
public class AOPTestController {
	
	@GetMapping("/json1")
	@CheckAuth
	@ResponseBody
	public ResponseEntity<String> sendJson1(@ModelAttribute UserInfoVO userInfo) {
		return new ResponseEntity<>("json1", HttpStatus.OK );
	}
	
	@GetMapping("/json2")
	public ResponseEntity<String> sendJson2() {
		return new ResponseEntity<>("json2",HttpStatus.OK);
	}
}
