package my.test.spring.user.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.test.spring.board.service.BoardService;
import my.test.spring.user.service.UserService;
import my.test.spring.user.vo.UserVO;



@Controller // 컨트롤러로 관리될 클래스
@SessionAttributes({"login", "register"}) // 세션에 "login"과 "register"라는 이름으로 객체를 저장하겠다는 선언
public class UserController {
	
	Logger log = LogManager.getLogger("case3");

	
	@Autowired
	private UserService userService;

	// model 객체에 "register"라는 이름으로 UserVO 객체를 자동 추가
	@ModelAttribute("register")
	public UserVO createUser() {
		
		return new UserVO();
	}
	
	// 회원가입 요청을 처리하는 메소드
	@PostMapping("user/register")
	public String registerUser(UserVO userVO) {
		
		System.out.println("아무");
		log.debug("전달받은 데이터" + userVO);
		boolean result = userService.registerUser(userVO);
		String viewName = "";
		
		if(result) {
			// 회원가입 성공
			viewName = "redirect:/resources/login.html";
			
		} else {
			// 회원가입 실패
			viewName = "redirect:/resources/signup.html";
		}
				
		return viewName;
	}
	

	
	// 로그인 요청을 처리하는 메소드
	@PostMapping("user/login")
	public String loginUser(UserVO userVO, Model model) {
		
		log.debug("들어옴");
		
		boolean result = userService.loginUser(userVO);
	    String viewName = "";

	    if (result) {
	    	// 로그인 성공
	    	model.addAttribute("login", userVO);
	        viewName = "redirect:/board/list";
	    } else {
	    	// 로그인 실패
	        viewName = "redirect:/resources/login.html";
	    }

	    return viewName;
	}
	

	
	// 사용자 수정 (update)
	@PostMapping("board/update_user")
	public String updateInfo(UserVO uservo) {
		
		log.debug("controller {}", uservo);
		userService.updateUser(uservo);
		
		return "redirect:/board/list";

		}
	
	
}
