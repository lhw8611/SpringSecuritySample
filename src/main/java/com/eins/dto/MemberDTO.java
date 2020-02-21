package com.eins.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDTO {
	private int		memNum;
	private String  memId;
	private String  memUserName;
	private String  memPassword;
	private String  memGrade;
	private Date    memRegDate;
}
