package org.odiy.spring.controllers;

import java.util.List;

import org.odiy.spring.helper.RetrofitHelper;
import org.odiy.spring.model.TourApi;
import org.odiy.spring.model.TourApi.Response.Body.Items.Item;
import org.odiy.spring.service.CollectTourApiService;
import org.odiy.spring.service.TourApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Retrofit;

/** @filename	: TourApiScheduler.java
 * @description	: 
 * @author		: 박 통 영 (zawookmist@gmail.com)
 */
@Slf4j
@Controller
public class CollectTourApiController {
	@Autowired
	RetrofitHelper retrofitHelper;
	@Autowired
	TourApiService tourApiService;

	@ResponseBody
	@RequestMapping(value="/collectTourApi.do", method=RequestMethod.GET)
	public void collectTourApi() {
		
		/** API 연동 객체 생성 */
		Retrofit retrofit = retrofitHelper.getRetrofit(CollectTourApiService.BASE_URL);
		// Service 객체 생성
		CollectTourApiService collectTourApiService = retrofit.create(CollectTourApiService.class);
		/** 파라미터 처리 */
		// 파라미터 요청용 pageNo값 선언
		int pageNum=1;
		String pageNo = ""+pageNum;
		int totalCount = 0;
		int numOfRows = 0;
		
		/** API 요청 */

		Call<TourApi> call = collectTourApiService.getTourApi(pageNo);
		TourApi tourApi = null;
		try {
			tourApi = call.execute().body();
			totalCount = tourApi.getResponse().getBody().getTotalCount();
			numOfRows = tourApi.getResponse().getBody().getNumOfRows();
			log.debug(" >> totalCount : " + totalCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		for (int i=0; i<( totalCount / numOfRows ) + 1 ; i++) {
//			log.debug(String.format(" >>>>> Call pages : %d of %d", (totalCount/numOfRows)+1, i+1));
			
			call = collectTourApiService.getTourApi(pageNo);
			tourApi = null;
			try {
				tourApi = call.execute().body();
				totalCount = tourApi.getResponse().getBody().getTotalCount();
				numOfRows = tourApi.getResponse().getBody().getNumOfRows();
				log.debug(" >> totalCount : " + totalCount);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			List<Item> list = null;

			// 검색 결과가 있다면 list 추출
			if (tourApi != null) {
				list = tourApi.getResponse().getBody().getItems().getItem();

			} else {
				log.debug("조회 결과 없음");
				return;
			}
			
			// OpenAPI 조회결과의 Beans에 검색 조건 추가 후 로그를 통해 내역 확인
			
			for (Item item : list) {
				log.debug(item.toString());
			}
			
			/** 수집결과 저장 */
			try {
				tourApiService.collectTourApiList(list);
			} catch (Exception e) {
				log.error(e.getLocalizedMessage());
				e.printStackTrace();
			}
			
//			pageNum++;
//			pageNo=""+pageNum;
//		}
		
	}
}