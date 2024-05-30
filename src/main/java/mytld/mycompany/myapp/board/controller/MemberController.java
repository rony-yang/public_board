package mytld.mycompany.myapp.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mytld.mycompany.myapp.board.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	/* 회원가입 페이지 렌더링 */
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String getRegister() {
		return "member/register";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLogin() {
		return "member/login";
	}

	
}
