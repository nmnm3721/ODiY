package org.odiy.spring.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.odiy.spring.helper.RegexHelper;
import org.odiy.spring.helper.RetrofitHelper;
import org.odiy.spring.helper.WebHelper;
import org.odiy.spring.model.ApiItem;
import org.odiy.spring.model.TourApiDetail.Response.Body.Items.Item;
import org.odiy.spring.model.TourApiDetail;
import org.odiy.spring.service.CollectTourApiService;
import org.odiy.spring.service.TourApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Retrofit;

@Slf4j
@Controller
public class DetailpageController {

	/** WebHelper 주입 */
	// --> import org.springframework.beans.factory.annotation.Autowired;
	// --> import study.spring.springhelper.helper.WebHelper;
	@Autowired
	WebHelper webHelper;

	/** RegexHelper 주입 */
	// --> import study.spring.springhelper.helper.RegexHelper;
	@Autowired
	RegexHelper regexHelper;

	/** RetrofitHelper 주입 */
	// --> import study.spring.springhelper.helper.RegexHelper;
	@Autowired
	RetrofitHelper retrofitHelper;

	/** Service 패턴 구현체 주입 */
	// --> import study.spring.springhelper.service.ProfessorService;
	@Autowired
	TourApiService tourApiService;

	/** "/프로젝트이름" 에 해당하는 ContextPath 변수 주입 */
	// --> import org.springframework.beans.factory.annotation.Value;
	@Value("#{servletContext.contextPath}")
	String contextPath;

	@RequestMapping(value = "/detailpage/detail.do", method = RequestMethod.GET)
	public ModelAndView detail(Locale locale, Model model,
			@RequestParam(value = "contentid", required = false) Integer contentid,
			@RequestParam(value = "contenttypeid", required = false) Integer contenttypeid,
			@RequestParam(value = "mapx", required = false) Double mapx,
			@RequestParam(value = "mapy", required = false) Double mapy) {

		/*****************************************************************************************/
		
		final Map<String, String> options = new HashMap<String, String>();
		
		//log.debug("!@$#$^$#%^$%#&%$^*" + contenttypeid);
		
		options.put("contentId", contentid + "");
		options.put("contentTypeId", contenttypeid + "");

		/** API 연동 객체 생성 */
		Retrofit retrofit = retrofitHelper.getRetrofit(CollectTourApiService.BASE_URL);
		// Service 객체 생성
		CollectTourApiService collectTourApiService = retrofit.create(CollectTourApiService.class);

		/** API 요청 */

		Call<TourApiDetail> callBase = collectTourApiService.getDetailItem(contentid);
		Call<TourApiDetail> callIntro = collectTourApiService.getDetailItemIntro(options);
		
		TourApiDetail tourApiDetail = null;
		TourApiDetail tourApiIntro = null;
		
		Item itemBase = null;
		Item itemIntro = null;

		try {
			tourApiDetail = callBase.execute().body();
			tourApiIntro = callIntro.execute().body();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (tourApiDetail != null) {
			itemBase = tourApiDetail.getResponse().getBody().getItems().getItem();
		} else {
			log.debug("조회 결과 없음");
			return webHelper.redirect(null, "조회 결과 없음");
		}
		if (tourApiIntro != null) {
			itemIntro = tourApiIntro.getResponse().getBody().getItems().getItem();
		} else {
			log.debug("조회 결과 없음");
			return webHelper.redirect(null, "조회 결과 없음");
		}
		

		// OpenAPI 조회결과의 Beans에 검색 조건 추가 후 로그를 통해 내역 확인
		//log.debug("!@$#$^#$%&" + item.toString());

		/*****************************************************************************************/

		/** 데이터 조회하기 */
		// 조회에 필요한 조건값(검색어)를 Beans에 담는다.
		ApiItem input = new ApiItem();
		input.setContentid(contentid);

		ApiItem output = null; // 조회결과가 저장될 객체

		try {

			// 데이터 조회하기
			output = tourApiService.getTourApiItem(input);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}

		
		/** 추천데이터 조회하기 */
		// 조회에 필요한 조건값(검색어)를 Beans에 담는다.
		ApiItem recommendInput = new ApiItem();
		recommendInput.setMapx(mapx);
		recommendInput.setMapy(mapy);
		ApiItem.setOffset(0);
		ApiItem.setListCount(3);

		List<ApiItem> recommendOutput = null; // 조회결과가 저장될 객체

		try {

			// 데이터 조회하기
			recommendOutput = tourApiService.getDetailRecommend(recommendInput);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}
		
		
		/** 주변축제데이터 조회하기 */
		// 조회에 필요한 조건값(검색어)를 Beans에 담는다.
		ApiItem festivalInput = new ApiItem();
		festivalInput.setContenttypeid(15);
		festivalInput.setMapx(mapx);
		festivalInput.setMapy(mapy);
		ApiItem.setOffset(0);
		ApiItem.setListCount(3);

		List<ApiItem> festivalOutput = null; // 조회결과가 저장될 객체

		try {

			// 데이터 조회하기
			festivalOutput = tourApiService.getDetailFestival(festivalInput);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}
		
		
		
		/** View 처리 */
		model.addAttribute("output", output);
		model.addAttribute("itemBase", itemBase);
		model.addAttribute("itemIntro", itemIntro);
		model.addAttribute("recommendOutput", recommendOutput);
		model.addAttribute("festivalOutput", festivalOutput);
		
		return new ModelAndView("detailpage/detail");
	}

}
