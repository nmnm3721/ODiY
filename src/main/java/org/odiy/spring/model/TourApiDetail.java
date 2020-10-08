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
public class TourApiDetail {

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
				private Item item;
				
				@Data
				public class Item {
					@SerializedName("overview")
					@Expose
					private String overview;
					@SerializedName("homepage")
					@Expose
					/** 이용시간 관련 변수 */
					private String homepage;
					@SerializedName("usetime")
					@Expose
					private String usetime;
					@SerializedName("usetimeculture")
					@Expose
					private String usetimeculture;
					@SerializedName("usetimeleports")
					@Expose
					private String usetimeleports;
					/** 휴일관련 변수 */
					@SerializedName("restdate")
					@Expose
					private String restdate;
					@SerializedName("restdateculture")
					@Expose
					private String restdateculture;
					@SerializedName("restdateleports")
					@Expose
					private String restdateleports;
					@SerializedName("restdateshopping")
					@Expose
					private String restdateshopping;
					@SerializedName("restdatefood")
					@Expose
					private String restdatefood;
					/** 주차시설 관련 변수*/
					@SerializedName("parking")
					@Expose
					private String parking;
					@SerializedName("parkingculture")
					@Expose
					private String parkingculture;
					@SerializedName("parkingleports")
					@Expose
					private String parkingleports;
					@SerializedName("parkinglodging")
					@Expose
					private String parkinglodging;
					@SerializedName("parkingshopping")
					@Expose
					private String parkingshopping;
					@SerializedName("parkingfood")
					@Expose
					private String parkingfood;
					/** 이용요금 관련 변수*/
					@SerializedName("usefee")
					@Expose
					private String usefee;
					@SerializedName("usetimefestival")
					@Expose
					private String usetimefestival;
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
