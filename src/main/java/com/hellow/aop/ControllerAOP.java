package com.hellow.aop;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ControllerAOP {
	@Around("@annotation(com.hellow.anno.CheckAuth)")
	public Object aroundController(ProceedingJoinPoint pjp) throws Throwable {
		ServletRequestAttributes reqAttr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = reqAttr.getRequest();
		HttpSession session = req.getSession();
		if(session.getAttribute("userInfo")==null) {
			return new ResponseEntity<>("로그인 점 ㅎ", HttpStatus.UNAUTHORIZED);
		}
		return pjp.proceed();
	}
	
	@Around("execution(* com.hellow.controller.ViewsController.goPage(..))")
	public Object viewAuthCheck(ProceedingJoinPoint pjp) throws Throwable {
		ServletRequestAttributes reqAttr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = reqAttr.getRequest();
		HttpSession session = req.getSession();
		
		String uri = req.getRequestURI();
		
		if(uri.startsWith("/views/auth/")&& session.getAttribute("userInfo")==null) {
			req.setAttribute("msg", "로그인 필요");
			return "views/login";
		}
		
		Object ojb = pjp.proceed();
		if(ojb==null) {
			log.debug("type of=>null");
			return null;
		}
		log.debug("type of=>{}", ojb.getClass());
		return ojb;
	}
	
}
