package com.hellow;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import com.hellow.service.BoxOfficeService;
import com.hellow.vo.BoxOfficeVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@PropertySource("classpath:env.properties")
class HellowApplicationTests {
	@Autowired
	private BoxOfficeService boxOfficeService;
	
	@Test
	void contextLoads() {
		List<BoxOfficeVO> boxOfficeList = boxOfficeService.selectBoxOffices(30);
		int result = boxOfficeService.insertBoxOffices(boxOfficeList);
		log.info("result=>{}",result);
	}

}
