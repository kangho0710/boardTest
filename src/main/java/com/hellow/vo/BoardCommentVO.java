package com.hellow.vo;

import lombok.Data;

@Data
public class BoardCommentVO {
	private int bcNum;
	private int tbNum;
	private String bcWriter;
	private String bcContent;
	private String bcCredat;
	private String bcModdat;
	private int bcActive;
}
