package org.odiy.spring.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.odiy.spring.helper.RegexHelper;
import org.odiy.spring.helper.WebHelper;
import org.odiy.spring.model.User;
import org.odiy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SignupController {
	
	/** WebHelper 주입 */
	@Autowired
	WebHelper webHelper;

	/** RegexHelper 주입 */
	@Autowired
	RegexHelper regexHelper;

	/** Service 패턴 구현체 주입 */
	@Autowired
	UserService userService;

	/** 메일 서비스를 사용하기 위해 의존성을 주입함. */
	@Autowired
	JavaMailSender mailSender;     
	
	/** "/프로젝트이름" 에 해당하는 ContextPath 변수 주입 */
	// --> import org.springframework.beans.factory.annotation.Value;
	@Value("#{servletContext.contextPath}")
	String contextPath;
	
    /** mailSending(인증메일전송) */
    @RequestMapping( value = "/signup/auth.do" , method=RequestMethod.POST )
    public ModelAndView mailSending(
    		@RequestParam(value = "userEmail", required = false) String userEmail,
    		HttpServletRequest request, HttpServletResponse response_email) throws IOException {
		/** 이메일 유효성 검증 */
		// POSTMAN 등의 클라이언트 프로그램으로 백엔드에 직접 접속하는 경우를 방지하기 위해
		// REST컨트롤러에서도 프론트의 유효성 검증과 별개로 자체 유효성 검증을 수행해야 한다.
		if (!regexHelper.isEmail(userEmail)) {
			return webHelper.redirect(null, "이메일이 잘못되었습니다.");
		}
		
		User input = new User();
		input.setUserEmail(userEmail);
    	
		try {
			userService.emailUniqueCheck(input);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}
		
        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
        
        String setfrom = "chjy944@gmail.com";
        String tomail = request.getParameter("userEmail"); // 받는 사람 이메일
        String title = "ODiY 회원가입을 위한 인증 이메일 입니다."; // 제목
        String content =
        
        System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
        
        System.getProperty("line.separator")+
                
        "안녕하세요 회원님, ODiY를 찾아주셔서 감사합니다."
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " 인증번호는 " + dice + " 입니다. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "위 인증번호를 홈페이지에 입력해 주시면 회원가입이 진행 됩니다."; // 내용
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(tomail); // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content); // 메일 내용
            
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mv.setViewName("/signup/signup_email_injeung");     //뷰의이름
        
        // 결과값을 다음 페이지로 전송
        mv.addObject("dice", dice);
        mv.addObject("userEmail", userEmail);
        
        System.out.println("mv : " + mv);

        response_email.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response_email.getWriter();
        out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
        out_email.flush();
        
        
        return mv;
        
    }

	//이메일 인증 페이지 맵핑 메소드
    //이메일 인증 페이지 맵핑 메소드
    @RequestMapping("/signup/email.do")
    public String email() {
        return "signup/signup_email";
    }
	
	
	//이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
	//내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
	//틀리면 다시 원래 페이지로 돌아오는 메소드
	@RequestMapping(value = "/signup/join_injeung.do{dice}", method = RequestMethod.POST)
	public ModelAndView join_injeung(String email_injeung, String userEmail, @PathVariable String dice, HttpServletResponse response_equals) throws IOException {
	
	    
	    System.out.println("마지막 : email_injeung : "+email_injeung);
	    
	    System.out.println("마지막 : dice : "+ dice);
	    
	    System.out.println("마지막 : userEmail : "+ userEmail);
	    
	    //페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
	     
	    ModelAndView mv = new ModelAndView();	    
	    	mv.setViewName("/signup/join.do");
	    	mv.addObject("email_injeung",email_injeung);
	   		mv.addObject("userEmail",userEmail); 
	    
	    if (email_injeung.equals(dice)) {
	        
	        //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
	        
	        
	        
            mv.setViewName("signup/signup_main");
            
            mv.addObject("userEmail",userEmail); // dice값은 는 넘어가 지는데 userEmail은 왜 안되나
	        
	        //만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
	        //한번더 입력할 필요가 없게 한다.
	        
	        response_equals.setContentType("text/html; charset=UTF-8");
	        PrintWriter out_equals = response_equals.getWriter();
	        out_equals.println("<script>alert('인증번호가 일치하였습니다. 회원가입창으로 이동합니다.');</script>");
	        out_equals.flush();
	
	        return mv;
	        
	        
	    }else if (email_injeung != dice) {
		    
		    System.out.println("인증실패시 : email_injeung : "+email_injeung);
		    
		    System.out.println("인증실패시 : dice : "+ dice);
		    
		    System.out.println("인증실패시 : userEmail : "+ userEmail);
	        
	        ModelAndView mv2 = new ModelAndView(); 
	        
	        mv2.setViewName("signup/signup_email_injeung");
	        mv2.addObject("email_injeung",userEmail);
	        mv2.addObject("userEmail",userEmail);
	        
	        response_equals.setContentType("text/html; charset=UTF-8");
	        PrintWriter out_equals = response_equals.getWriter();
	        out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); </script>");
	        out_equals.flush();
	
	        return mv2;
	        
	    }    
	
	    return mv;
	    
	}


    /** 이메일인증 끝*/	


	
	@RequestMapping(value = "/signup/signup.do", method = RequestMethod.GET)
	public String myPlan(Locale locale, Model model) {

		return "signup/signup2";
	}

	@RequestMapping(value = "/signup/tosign.do", method = RequestMethod.POST)
	public String signup(Locale locale, Model model) {

		return "signup/tosign";
	}

	/** 회원가입 */
	@RequestMapping(value = "/signup/joins.do", method = RequestMethod.POST)
	public ModelAndView joins(Model model, 
			@RequestParam(value = "user_email", required = false) String userEmail,
			@RequestParam(value = "user_pw", required = false) String userPw,
			@RequestParam(value = "user_pw_re", required = false) String userPwRe,
			@RequestParam(value = "txtDate", required = false) String userBirthday,
			@RequestParam(value = "user_name", required = false) String userName) {		
			//String userBirthday =getuserBirthday.replaceAll("/", "-");
		
		/** 1) 유효성 검증 */
		// POSTMAN 등의 클라이언트 프로그램으로 백엔드에 직접 접속하는 경우를 방지하기 위해
		// REST컨트롤러에서도 프론트의 유효성 검증과 별개로 자체 유효성 검증을 수행해야 한다.
      
		if (!regexHelper.isEmail(userEmail)) {
			return webHelper.redirect(null, "이메일이 잘못되었습니다.");
		}
		if (!regexHelper.isValue(userPw)) {
			return webHelper.redirect(null, "비밀번호를 입력하세요.");
		}
		if (userPw.length() < 4 || userPw.length() > 30) {
			return webHelper.redirect(null, "비밀번호는 4~30글자로 입력 가능합니다.");
		}
		if (!userPw.equals(userPwRe)) {
			return webHelper.redirect(null, "비밀번호는 확인이 잘못되었습니다.");
		}
		if (!regexHelper.isValue(userBirthday)) {
			return webHelper.redirect(null, "생년월일을 입력하세요.");
		}

		/** 3) 데이터 저장 */
		User input = new User();
		input.setUserEmail(userEmail);
		input.setUserPw(userPw);
		input.setUserName(userName);
		input.setUserBirthday(userBirthday);
		input.setIsAdmin("N"); // 관리자 아님
		input.setIsOut("N"); // 탈퇴아님 --> 탈퇴시 'Y'로 업데이트

		try {
			userService.addUser(input);
		} catch (Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}

		String redirectUrl = contextPath + "/";

		/** 4) 결과 표시 */
		return webHelper.redirect(redirectUrl, "회원가입이 성공하였습니다. 로그인 해주세요.");
	}
	
	
	
	

}
