package com.hellow.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellow.api.ApiBoxOffice;
import com.hellow.mapper.BoxOfficeMapper;
import com.hellow.vo.BoxOfficeVO;

@Service
@Mapper
public class BoxOfficeService {
	@Autowired
	private ApiBoxOffice apiBoxOffice;
	@Autowired
	private BoxOfficeMapper boxOfficeMapper;
	
	public int insertBoxOffices(List<BoxOfficeVO> boxOfficeList) {
		return boxOfficeMapper.insertBoxOffices(boxOfficeList);
	}
	
	public List<BoxOfficeVO> selectBoxOffices(int cnt){
		return apiBoxOffice.getBoxOfficeList(cnt);
	}
}
