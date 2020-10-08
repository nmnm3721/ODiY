package org.odiy.spring;

import org.junit.runners.MethodSorters;
import org.odiy.spring.helper.RetrofitHelper;
import org.odiy.spring.model.TourApi;
import org.odiy.spring.model.TourApi.Response.Body.Items.Item;
import org.odiy.spring.service.CollectTourApiService;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.runner.RunWith;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * @filename : collectTourApiTest.java
 * @description :
 * @author : 박 통 영 (zawookmist@gmail.com)
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" })
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class collectTourApiTest {
	// RetrofitHelper 객체 주입
	@Autowired
	RetrofitHelper retrofitHelper;

	@Test
	public void collectTest() {
		/** API 연동 객체 생성 */
		// Retrofit 객체 생성
		Retrofit retrofit = retrofitHelper.getRetrofit(CollectTourApiService.BASE_URL);
		// Service 객체 생성, 구현체는 Retrofit이 자동으로 생성한다.
		CollectTourApiService collectTourApiService = retrofit.create(CollectTourApiService.class);

		/** 검색 파라미터 처리 */
		String pageNo = "1";
		// TourApi에서 검색결과 받아오기
		Call<TourApi> call = collectTourApiService.getTourApi(pageNo);
		TourApi tourApi = null;
		try {
			tourApi = call.execute().body();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/** 조회결과를 반복문을 활용하여 출력 */
		if (tourApi != null) {
			List<Item> list = tourApi.getResponse().getBody().getItems().getItem();

			for (Item item : list) {
				log.debug(" >>> 불러온 TourAPI : " + item.toString());
			}
		}
	}

}
