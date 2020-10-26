package org.odiy.spring.controllers;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SearchController {

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

	@RequestMapping(value = "/search/search.do", method = RequestMethod.GET)
	public ModelAndView search(Model model,
			// 검색어
			@RequestParam(value = "keyword", required = false) String keyword,
			// 여행지식당숙박
			@RequestParam(value="tour_eat_zzz", defaultValue="tour") String tour_eat_zzz,
			// 지역코드
//			@RequestParam(value="detail_area", required=false) String detail_area,
			// 분류코드
//			@RequestParam(value="detail_cat1", required=false) String detail_cat1,
			// 정렬
			@RequestParam(value="detail_desc", defaultValue="createdtime-desc") String detail_desc,
			// 페이지 구현에서 사용할 현재 페이지 번호
			@RequestParam(value = "page", defaultValue = "1") int nowPage) {

		/** 1) 페이지 구현에 필요한 변수값 생성 */
		int totalCount = 0; // 전체 게시글 수
		int listCount = 10; // 한 페이지당 표시할 목록 수
		int pageCount = 5; // 한 그룹당 표시할 페이지 번호 수
		
		// 파라미터 기본값 지정
		if (tour_eat_zzz == null || tour_eat_zzz == "") {
			tour_eat_zzz = "tour";
		}
		if (keyword == null) {
			keyword = "";
		}
//		if (detail_area==null) {
//			detail_area="";
//		}
//		if (detail_cat1==null) {
//			detail_cat1="";
//		}
		if (detail_desc==null || detail_desc=="") {
			detail_desc="createdtime-desc";
		}
		
		keyword = keyword.replace(" ", "");
		
		/** 2) 데이터 조회하기 */
		// 조회에 필요한 조건값(검색어)를 Beans에 담는다.
		ApiItem input = new ApiItem();
		input.setTitle(keyword);
		input.setTourEatZzz(tour_eat_zzz);
//		input.setAreacode(detail_area);
//		input.setCat1(detail_cat1);
		input.setDesc(detail_desc);

		List<ApiItem> output = null; // 조회결과가 저장될 객체
		PageData pageData = null; // 페이지 번호를 계산한 결과가 저장될 객체

		try {
			// 전체 게시글 수 조회
			totalCount = tourApiService.getTourApiCount(input);
			// 페이지 번호 계산 --> 계산결과를 로그로 출력될 것이다.
			pageData = new PageData(nowPage, totalCount, listCount, pageCount);

			// SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
			ApiItem.setOffset(pageData.getOffset());
			ApiItem.setListCount(pageData.getListCount());

			// 데이터 조회하기
			output = tourApiService.getTourApiList(input);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}

		/** 3) View 처리 */
		model.addAttribute("keyword", keyword);
		model.addAttribute("output", output);
		model.addAttribute("pageData", pageData);
		model.addAttribute("tour_eat_zzz", tour_eat_zzz);
//		model.addAttribute("detail_area", detail_area);
//		model.addAttribute("detail_cat1", detail_cat1);
		model.addAttribute("detail_desc", detail_desc);

		return new ModelAndView("search/search");
	}

}
