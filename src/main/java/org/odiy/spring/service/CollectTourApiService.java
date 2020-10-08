package org.odiy.spring.service;

import java.util.Map;

import org.odiy.spring.model.TourApi;
import org.odiy.spring.model.TourApiDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/** @filename	: CollectTourApiService.java
 * @description	: 
 * @author		: 박 통 영 (zawookmist@gmail.com)
 */
public interface CollectTourApiService {

	public static final String BASE_URL = "http://api.visitkorea.or.kr";

	@GET("/openapi/service/rest/KorService/areaBasedList?ServiceKey=Dt5SNAv5PZqa12ePX8Jvvrsbv1551%2BPLm%2FKFQ6hNGdoePgAvbS6SlgUzlxIfhc2dYja2s2UDzAv4bEXuizVYZA%3D%3D&numOfRows=100&MobileApp=odiy&MobileOS=ETC&arrange=D&listYN=Y&_type=json")
	Call<TourApi> getTourApi(@Query("pageNo") String pageNo);
	
	@GET("/openapi/service/rest/KorService/detailCommon?ServiceKey=Dt5SNAv5PZqa12ePX8Jvvrsbv1551%2BPLm%2FKFQ6hNGdoePgAvbS6SlgUzlxIfhc2dYja2s2UDzAv4bEXuizVYZA%3D%3D&MobileApp=odiy&MobileOS=ETC&defaultYN=Y&overviewYN=Y&_type=json")
	Call<TourApiDetail> getDetailItem(@Query("contentId") int contentid);
	
	@GET("/openapi/service/rest/KorService/detailIntro?ServiceKey=Dt5SNAv5PZqa12ePX8Jvvrsbv1551%2BPLm%2FKFQ6hNGdoePgAvbS6SlgUzlxIfhc2dYja2s2UDzAv4bEXuizVYZA%3D%3D&MobileApp=odiy&MobileOS=ETC&_type=json")
	Call<TourApiDetail> getDetailItemIntro(@QueryMap Map<String, String> options);

}
