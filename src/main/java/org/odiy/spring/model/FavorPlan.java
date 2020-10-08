package org.odiy.spring.model;

import lombok.Data;

/** @filename	: FavorPlan.java
 * @description	: 
 * @author		: 박 통 영 (zawookmist@gmail.com)
 */
@Data
public class FavorPlan {
	
	private int favorId;
	private String isPlan;
	private Integer userNum;
	private Integer contentid;
	
	private static int offset;

	private static int listCount;

	public static int getOffset() {
		return offset;
	}

	public static void setOffset(int offset) {
		FavorPlan.offset = offset;
	}

	public static int getListCount() {
		return listCount;
	}

	public static void setListCount(int listCount) {
		FavorPlan.listCount = listCount;
	}

	

}
