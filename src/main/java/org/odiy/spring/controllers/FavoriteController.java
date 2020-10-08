package org.odiy.spring.controllers;

import java.util.Locale;

import org.odiy.spring.helper.RegexHelper;
import org.odiy.spring.helper.WebHelper;
import org.odiy.spring.model.FavorPlan;
import org.odiy.spring.service.FavoriteService;
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
public class FavoriteController {
	
	/** WebHelper 주입 */
	@Autowired
	WebHelper webHelper;

	/** RegexHelper 주입 */
	@Autowired
	RegexHelper regexHelper;

	/** Service 패턴 구현체 주입 */
	@Autowired
	UserService userService;

	/** "/프로젝트이름" 에 해당하는 ContextPath 변수 주입 */
	@Value("#{servletContext.contextPath}")
	String contextPath;
	
	
	@Autowired
	FavoriteService favoriteService;
	
	
	@RequestMapping(value = "/favorite_add.do", method = RequestMethod.POST)
	public ModelAndView favorite_add(Locale locale, Model model,
			@RequestParam(value = "pagename", required = false) String pagename,
			@RequestParam(value = "contentid", required = false) Integer contentid,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "userNum", required = false) Integer userNum) {
		
		FavorPlan input = new FavorPlan();
		input.setContentid(contentid);
		input.setUserNum(userNum);
		
		if (userNum == null) {
			return webHelper.redirect(null, "로그인 해주세요.");
		}
		if (contentid == null) {
			return webHelper.redirect(null, "잘못된 접근입니다.");
		}
		
		int check_du = 0;
		
		try {
			check_du = favoriteService.checkFavoriteItem(input);
			//log.debug("@#%@#$^#$%&^%$^&$%^&$%^&$%^7" + check_du);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (check_du > 0) {
			return webHelper.redirect(null, "이미 추가된 항목입니다.");
		}
		
		/** 수집결과 저장 */
		try {
			int check_add = favoriteService.insertFavoriteItem(input);
			log.debug("저장성공시 1 반환 : " + check_add);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		

		return webHelper.redirect(null, "즐겨찾기에 추가되었습니다.");
	}
	
	@RequestMapping(value = "/favorite_del.do", method = RequestMethod.POST)
	public ModelAndView favorite_del(Model model,
			@RequestParam(value = "contentid", required = false) Integer contentid,
			@RequestParam(value = "userNum", required = false) Integer userNum) {
		
		/** 1) 유효성 검사 */
		// 이 값이 존재하지 않는다면 데이터 삭제가 불가능하므로 반드시 필수값으로 처리해야 한다.
	        if (contentid == null || userNum == null) {
	            return webHelper.redirect(null, "잘못된 처리입니다.");
	        }

	        /** 2) 데이터 삭제하기 */
	        // 데이터 삭제에 필요한 조건값을 Beans에 저장하기
	        FavorPlan input = new FavorPlan();
	        input.setUserNum(userNum);
	        input.setContentid(contentid);

	        try {
	            favoriteService.deleteFavorite(input); // 데이터 삭제
	        } catch (Exception e) {
	            return webHelper.redirect(null, e.getLocalizedMessage());
	        }

	        /** 3) 페이지 이동 */
	        // 확인할 대상이 삭제된 상태이므로 목록 페이지로 이동
	        return webHelper.redirect(contextPath + "/mypage/mypage.do?userNum=" + userNum, "삭제되었습니다.");
	}
	

}
