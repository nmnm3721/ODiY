package org.odiy.spring.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.odiy.spring.helper.PageData;
import org.odiy.spring.helper.RegexHelper;
import org.odiy.spring.helper.WebHelper;
import org.odiy.spring.model.ApiItem;
import org.odiy.spring.service.TourApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	/** WebHelper 주입 */
	// --> import org.springframework.beans.factory.annotation.Autowired;
	// --> import study.spring.springhelper.helper.WebHelper;
	@Autowired
	WebHelper webHelper;

	/** RegexHelper 주입 */
	// --> import study.spring.springhelper.helper.RegexHelper;
	@Autowired
	RegexHelper regexHelper;

	/** Service 패턴 구현체 주입 */
	// --> import study.spring.springhelper.service.ProfessorService;
	@Autowired
	TourApiService tourApiService;

	/** "/프로젝트이름" 에 해당하는 ContextPath 변수 주입 */
	// --> import org.springframework.beans.factory.annotation.Value;
	@Value("#{servletContext.contextPath}")
	String contextPath;

	@RequestMapping(value = { "/", "home.do" }, method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {

		log.debug("Locale : " + locale.getLanguage());
		log.debug("Locale : " + locale.getCountry());
		log.debug("Locale : " + locale.getDisplayLanguage());
		log.debug("Locale : " + locale.getDisplayCountry());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		/** 데이터 조회하기(메인배너이미지) */
		// 조회에 필요한 조건값(검색어)를 Beans에 담는다.
		ApiItem input = new ApiItem();

		List<ApiItem> output = null; // 조회결과가 저장될 객체

		try {

			// SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
			ApiItem.setOffset(0);
			ApiItem.setListCount(5);

			// 데이터 조회하기
			output = tourApiService.getTourApiImage(input);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}

		model.addAttribute("output", output);
		
		
		/** 데이터 조회하기(오늘의 추천이미지) */
		// 조회에 필요한 조건값(검색어)를 Beans에 담는다.
		ApiItem inputRecommend = new ApiItem();
		
		List<ApiItem> outputRecommend = null; // 조회결과가 저장될 객체

		try {

			// SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
			ApiItem.setOffset(0);
			ApiItem.setListCount(5);

			// 데이터 조회하기
			outputRecommend = tourApiService.getTourApiRecommend(inputRecommend);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}
		
		
		/** 데이터 조회하기(오늘의 추천식당) */
		// 조회에 필요한 조건값(검색어)를 Beans에 담는다.
		ApiItem inputRecommendEat = new ApiItem();
		inputRecommendEat.setContenttypeid(39);
		
		List<ApiItem> outputRecommendEat = null; // 조회결과가 저장될 객체

		try {

			// SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
			ApiItem.setOffset(0);
			ApiItem.setListCount(5);

			// 데이터 조회하기
			outputRecommendEat = tourApiService.getTourApiRecommend(inputRecommendEat);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}

		
		model.addAttribute("outputRecommend", outputRecommend);
		model.addAttribute("outputRecommendEat", outputRecommendEat);
		
		
		
		return new ModelAndView("home");
	}

}
