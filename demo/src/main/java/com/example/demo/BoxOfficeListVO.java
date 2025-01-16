package com.example.demo;

import java.util.Date;

import lombok.Data;
@Data
public class BoxOfficeListVO {
	private int rnum;
    private int rank;
    private int rankInten;
    private String rankOldAndNew;
    private String movieCd;
    private String movieNm;
    private Date openDt;
    private String salesAmt;
    private Double salesShare;
    private Double salesInten;
    private Double salesChange;
    private int salesAcc;
    private int audiCnt;
    private Double audiInten;
    private Double audiChange;
    private int audiAcc;
    private int scrnCnt;
    private int showCnt;
}
