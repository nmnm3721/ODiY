package org.odiy.spring.controllers;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.odiy.spring.helper.RegexHelper;
import org.odiy.spring.helper.WebHelper;
import org.odiy.spring.model.User;
import org.odiy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
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
	// --> import org.springframework.beans.factory.annotation.Value;
	@Value("#{servletContext.contextPath}")
	String contextPath;
	
	 /** 로그인 */
    @RequestMapping(value = "/login/logingo.do", method = RequestMethod.POST)
    public ModelAndView logingo(Model model,HttpServletRequest request,
            @RequestParam(value = "user_email",        required = false) String userEmail,
            @RequestParam(value = "user_pw",        required = false) String userPw ) {
    	HttpSession session= request.getSession();  
    	
        /** 1) 유효성 검증 */
        // POSTMAN 등의 클라이언트 프로그램으로 백엔드에 직접 접속하는 경우를 방지하기 위해
        // REST컨트롤러에서도 프론트의 유효성 검증과 별개로 자체 유효성 검증을 수행해야 한다. 
        if (!regexHelper.isValue(userEmail)) { return webHelper.redirect(null,"아이디를 입력하세요."); }
        if (!regexHelper.isValue(userPw)) { return webHelper.redirect(null,"비밀번호를 입력하세요."); }

        /** 2) 데이터 조회 */
        User input = new User();
        input.setUserEmail(userEmail);
        input.setUserPw(userPw);
        
        /** 3) 로그인 */
        User output = null;
        
        try {
            output = userService.login(input);
        } catch (Exception e) {
            return webHelper.redirect(null,e.getLocalizedMessage());
        }
       

        /** 5) 세션 생성 및 결과 표시 */
            
        session.setAttribute("login_session_value", output);
        return webHelper.redirect(contextPath + "/", null);
    }
    @RequestMapping(value="login/logout.do")
    public ModelAndView logout(HttpSession session) {
    	session.invalidate();
    	return webHelper.redirect(contextPath+"/", "로그아웃 되었습니다.");
    }

}
