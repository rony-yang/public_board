package mytld.mycompany.myapp.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mytld.mycompany.myapp.board.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/* 회원가입 페이지 렌더링 */
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String getRegister() {
		return "member/register";
	}
	
	/* 회원가입 저장 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(@RequestParam Map<String, Object> map) {
	    this.memberService.register(map);
	    return "member/login";
	}
	
	/* 아이디 중복확인  */
    @PostMapping("/checkDuplicate")
    public @ResponseBody Map<String, Boolean> checkDuplicate(@RequestParam String id) {
        boolean isDuplicate = memberService.checkDuplicate(id);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("isDuplicate", isDuplicate);
        return response;
    }

	/* 로그인 페이지  */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLogin() {
		return "member/login";
	}
	
	/* 로그인 기능  */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String postLogin(@RequestParam("login_id") String loginId, @RequestParam("login_password") String loginPassword) {
		logger.info("아이디: " + loginId+" , 비밀번호: " + loginPassword);
		
	    return "redirect:/";
	}	
	
	
	
	
}
