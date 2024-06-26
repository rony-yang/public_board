package mytld.mycompany.myapp.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mytld.mycompany.myapp.board.dao.MemberDAO;
import mytld.mycompany.myapp.board.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
    @Autowired
    private MemberDAO memberDAO;
	
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
	public String getLogin(HttpSession session, Model model) {
	    String loginId = (String) session.getAttribute("loginId");
	    
	    // 이미 로그인 된 아이디가 있을 경우
	    if (loginId != null && !loginId.isEmpty()) {
	    	return "redirect:/?duplicate=true";
	    }
	    // 아이디 값이 없을 경우 정상 페이지 구성
	    return "member/login";
	}
	
	/* 로그인 기능  */
    @PostMapping("/login")
    public String postLogin(@RequestParam("login_id") String loginId, @RequestParam("login_password") String loginPassword,
            				HttpSession session, RedirectAttributes redirectAttributes) {
	
    	/* 세션 정보 확인하기
        StringBuilder sessionInfo = new StringBuilder();

        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = session.getAttribute(attributeName);
            sessionInfo.append(attributeName).append("=").append(attributeValue).append(", ");
        }

        if (sessionInfo.charAt(sessionInfo.length() - 1) == ' ') {
            sessionInfo.deleteCharAt(sessionInfo.length() - 1);
            sessionInfo.deleteCharAt(sessionInfo.length() - 1);
        }

        logger.info(sessionInfo.toString());
        */
        
        
		Map<String, Object> map = new HashMap<>();
		map.put("id", loginId);
		map.put("password", loginPassword);
		
		int result = memberDAO.login(map);

		if (result > 0) {
			session.setAttribute("loginId", loginId);
			logger.info("아이디: " + loginId + " , 비밀번호: " + loginPassword + " 로그인");
			return "redirect:/"; 
		} else {
			logger.info("아이디 또는 비밀번호가 잘못되었습니다.");
			redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
			redirectAttributes.addFlashAttribute("login_id", loginId);
			return "redirect:/login?error=true"; // 에러를 돌려주면서 alert 창 띄우기
		}
    }

    /* 로그아웃 기능 */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
	
}
