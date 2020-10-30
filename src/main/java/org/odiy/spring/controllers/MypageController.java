package org.odiy.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.odiy.spring.helper.PageData;
import org.odiy.spring.helper.RegexHelper;
import org.odiy.spring.helper.WebHelper;
import org.odiy.spring.model.ApiItem;
import org.odiy.spring.model.FavorPlan;
import org.odiy.spring.model.User;
import org.odiy.spring.service.FavoriteService;
import org.odiy.spring.service.TourApiService;
import org.odiy.spring.service.UserService;
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
public class MypageController {

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
	@Autowired
	FavoriteService favoriteService;

	/** Service 패턴 구현체 주입 */
	@Autowired
	TourApiService tourApiService;
	
	/** Service 패턴 구현체 주입 */
	@Autowired
	UserService userService;

	/** "/프로젝트이름" 에 해당하는 ContextPath 변수 주입 */
	// --> import org.springframework.beans.factory.annotation.Value;
	@Value("#{servletContext.contextPath}")
	String contextPath;

	@RequestMapping(value = "/mypage/mypage.do", method = RequestMethod.GET)
	public ModelAndView myPage(Model model, @RequestParam(value = "userNum", required = false) Integer userNum,
			@RequestParam(value = "page", defaultValue = "1") int nowPage) {

		int totalCount = 0; // 전체 게시글 수
		int listCount = 10; // 한 페이지당 표시할 목록 수
		int pageCount = 5; // 한 그룹당 표시할 페이지 번호 수

		/** 즐겨찾기 데이터베이스에서 컨텐츠 불러오기 */
		FavorPlan input = new FavorPlan();
		input.setUserNum(userNum);

		List<FavorPlan> content = null; // 조회결과가 저장될 객체
		PageData pageData = null; // 페이지 번호를 계산한 결과가 저장될 객체

		try {
			// 전체 게시글 수 조회
			totalCount = favoriteService.getFavoriteCount(input);

			// 데이터 조회하기
			content = favoriteService.getFavoriteList(input);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}

		/** 불러온 컨텐츠id로 데이터 불러오기 */

		List<ApiItem> output = new ArrayList<ApiItem>(); // 조회결과가 저장될 객체

		// 페이지 번호 계산 --> 계산결과를 로그로 출력될 것이다.
		pageData = new PageData(nowPage, totalCount, listCount, pageCount);

		for (FavorPlan item : content) {
			ApiItem temp = new ApiItem();
			temp.setContentid(item.getContentid());

			// 데이터 조회하기
			try {
				output.add(tourApiService.getTourApiItem(temp));
			} catch (Exception e) {
				return webHelper.redirect(null, e.getLocalizedMessage());
			}

		}

		/** 3) View 처리 */
		model.addAttribute("output", output);
		model.addAttribute("pageData", pageData);

		return new ModelAndView("mypage/mypage");
	}

	@RequestMapping(value = "mypage/mypage", method = RequestMethod.POST)
	public ModelAndView mypage(Model model,
			@RequestParam(value = "user_num", defaultValue = "0") int userNum,
			@RequestParam(value = "user_pw", required = false) String userPw,
			@RequestParam(value = "user_name", required = false) String userName) {
		// 1>파라미터 유효성검사 값존재안할때
		if (userNum == 0) {
			return webHelper.redirect(null, "유저번호가 없습니다");
		}

		// 데이터 조회
		/** 3) 데이터 저장 */
		User input = new User();
		input.setUserNum(userNum);
		input.setUserPw(userPw);
		input.setUserName(userName);
		input.setIsAdmin("N"); // 관리자 아님
		input.setIsOut("N"); // 탈퇴아님 --> 탈퇴시 'Y'로 업데이트

		try {
			userService.editUser(input);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}


		String redirectUrl = contextPath + "/mypage/mypage.do?userNum=" + userNum;

		/** 4) 결과 표시 */
		return webHelper.redirect(redirectUrl, "수정완료!");
	}
	
	@RequestMapping(value = "mypage/mypageout", method = RequestMethod.POST)
	public ModelAndView mypageout(Model model,
			@RequestParam(value = "user_num", defaultValue = "0") int userNum) {
		// 1>파라미터 유효성검사 값존재안할때
		if (userNum == 0) {
			return webHelper.redirect(null, "유저번호가 없습니다");
		}

		// 데이터 조회
		/** 3) 데이터 삭제 */
		User input = new User();
		input.setUserNum(userNum);
		input.setIsAdmin("N"); // 관리자 아님
		input.setIsOut("N"); // 탈퇴아님 --> 탈퇴시 'Y'로 업데이트

		try {
			userService.deleteUser(input);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}


		String redirectUrl = contextPath + "/mypage/mypageout.do?userNum=" + userNum;

		/** 4) 결과 표시 */
		return webHelper.redirect(contextPath+"/login/logout.do", "탈퇴완료!");
	}

}
