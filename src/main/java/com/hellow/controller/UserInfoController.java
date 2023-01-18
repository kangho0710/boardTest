package com.hellow.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.hellow.vo.KakaoLoginVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserInfoController {
	
	@GetMapping("/oauth")
	public String oauth(@RequestParam("code")String code, Model model) {
		model.addAttribute("code",code);
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://kauth.kakao.com/oauth/token";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "authorization_code");
		map.add("client_id","6c83f210141303408459aedd299bd5b3");
		map.add("redirect_uri", "http://localhost/oauth");
		map.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<KakaoLoginVO> res = restTemplate.postForEntity(uri, request, KakaoLoginVO.class);
		//access token 받아옴
		
		KakaoLoginVO kakaoLogin = res.getBody();
		model.addAttribute("kakaoLogin", res.getBody());
		uri = "https://kapi.kakao.com/v2/user/me";
		headers.set("Authorization","Bearer "+kakaoLogin.getAccess_token());
		ResponseEntity<String> res2 = restTemplate.postForEntity(uri, request, String.class);
		log.info("res=>{}",res2.getBody());
		return "views/kakao/oauth";
	}
}
