package mytld.mycompany.myapp.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String getRegister() {
		return "member/register";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLogin() {
		return "member/login";
	}

	
}
