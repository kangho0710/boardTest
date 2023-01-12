package com.hellow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  //자바에서 서블릿 역할 , //PREFIX //알아서 메모리 생성
public class ViewsController { 
	
	@GetMapping("/")
	public String home() {
		return "views/index";
	}
	
	@GetMapping("/views/**") //화면만 이동할거면 굳이 하나씩 매핑할 필요 없음
	public void goPage() {
		
	}
}
