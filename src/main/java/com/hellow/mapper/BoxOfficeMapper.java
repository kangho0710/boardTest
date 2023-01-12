package com.hellow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hellow.vo.BoxOfficeVO;

@Mapper
public interface BoxOfficeMapper {
	int insertBoxOffices(@Param("boxOfficeList") List<BoxOfficeVO> boxOfficeList);
	List<BoxOfficeVO> selectBoxOffices(int cnt);
}
