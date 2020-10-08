package org.odiy.spring.model;

import lombok.Data;

@Data
public class ApiItem {

	private Integer contentid;
	private Integer sigungucode;
	private String createdtime;
	private String modifiedtime;
	private String addr1;
	private String addr2;
	private Integer contenttypeid;
	private String cat1;
	private String cat2;
	private String cat3;
	private String firstimage;
	private String firstimage2;
	private Double mapx;
	private Double mapy;
	private String title;
	private String zipcode;
	private String tel;
	private Integer readcount;

	private String areacode;
	private String desc;
	private String tourEatZzz;
	
	private static int offset;

	private static int listCount;

	public static int getOffset() {
		return offset;
	}

	public static void setOffset(int offset) {
		ApiItem.offset = offset;
	}

	public static int getListCount() {
		return listCount;
	}

	public static void setListCount(int listCount) {
		ApiItem.listCount = listCount;
	}

}
