package mytld.mycompany.myapp.board.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	    logger.info("회원가입 요청: {}", map);
	    this.memberService.register(map);
	    return "member/login";
	}
	
	/* 아이디 중복확인
    @RequestMapping(value="/checkDuplicate", method=RequestMethod.POST)
    public String checkDuplicate(@RequestParam String id, Model model) {
        boolean isDuplicate = memberService.checkDuplicate(id);
        model.addAttribute("isDuplicate", isDuplicate);
        return "checkDuplicateResult";
    }	
     */
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLogin() {
		return "member/login";
	}

	
}
