package com.hellow.mapper;

import java.util.List;

import com.hellow.vo.FileInfoVO;

public interface FileInfoMapper {
	
	List<FileInfoVO> selectFileInfos();
	int insertFileInfo(FileInfoVO fileInfo);
}
