package org.odiy.spring.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * @filename : TourApi.java
 * @description : TourAPI 연동을 위한 모델
 * @author : 박 통 영 (zawookmist@gmail.com)
 */
@Data
public class TourApi {

	@SerializedName("response")
	private Response response;

	@Data
	public class Response {

		@SerializedName("header")
		private Header header;

		@Data
		public class Header {

			@SerializedName("resultCode")
			private String resultCode;
			@SerializedName("reslutMsg")
			private String resultMsg;
		}

		@SerializedName("body")
		private Body body;

		@Data
		public class Body {

			@SerializedName("items")
			private Items items;

			@Data
			public class Items {
				
				@SerializedName("item")
				private List<Item> item;
				
				@Data
				public class Item {
					
					@SerializedName("contentid")
					@Expose
					private Integer contentid;
					@SerializedName("sigungucode")
					@Expose
					private Integer sigungucode;
					@SerializedName("createdtime")
					@Expose
					private String createdtime;
					@SerializedName("modifiedtime")
					@Expose
					private String modifiedtime;
					@SerializedName("addr1")
					@Expose
					private String addr1;
					@SerializedName("addr2")
					@Expose
					private String addr2;
					@SerializedName("contenttypeid")
					@Expose
					private Integer contenttypeid;
					@SerializedName("cat1")
					@Expose
					private String cat1;
					@SerializedName("cat2")
					@Expose
					private String cat2;
					@SerializedName("cat3")
					@Expose
					private String cat3;
					@SerializedName("firstimage")
					@Expose
					private String firstimage;
					@SerializedName("firstimage2")
					@Expose
					private String firstimage2;
					@SerializedName("mapx")
					@Expose
					private Double mapx;
					@SerializedName("mapy")
					@Expose
					private Double mapy;
					@SerializedName("title")
					@Expose
					private String title;
					@SerializedName("zipcode")
					@Expose
					private String zipcode;
					@SerializedName("tel")
					@Expose
					private String tel;
					@SerializedName("readcount")
					@Expose
					private Integer readcount;
					@SerializedName("areacode")
					@Expose
					private String areacode;
				}
			}

			@SerializedName("numOfRows")
			@Expose
			private Integer numOfRows;

			@SerializedName("pageNo")
			@Expose
			private Integer pageNo;

			@SerializedName("totalCount")
			@Expose
			private Integer totalCount;

		}
	}
}
