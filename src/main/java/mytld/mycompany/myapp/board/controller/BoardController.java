package mytld.mycompany.myapp.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mytld.mycompany.myapp.board.service.BoardService;
import mytld.mycompany.myapp.board.vo.EditRequestVO;
import mytld.mycompany.myapp.board.vo.ListRequestVO;
import mytld.mycompany.myapp.board.vo.ListResponseVO;

@Controller
public class BoardController {

	@Autowired
	BoardService BoardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/* 글 쓰기 화면 렌더링 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String getCreate(Locale locale, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		
		// 로그인 된 아이디 찾기
	    String loginId = (String) session.getAttribute("loginId");
	    
	    // 로그인 된 회원만 글쓰기 가능
	    if (loginId == null || loginId.isEmpty()) {
	        redirectAttributes.addFlashAttribute("error", "로그인을 먼저 해주세요.");
	        return "redirect:/login";
	    }
		
		
		// 날짜 가져오기
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 EEEE", locale);
		String formattedDate = dateFormat.format(date);
		
		int nextSeqBoard = BoardService.getNextSeqBoard();
		
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("nextSeqBoard", nextSeqBoard);
        
		return "board/create";
	}
	
	/* 글 쓰기 화면 저장 */
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String postCreate(@RequestParam Map<String, Object> map, HttpSession session, RedirectAttributes redirectAttributes) {
		
	    String loginId = (String) session.getAttribute("loginId");

	    if (loginId == null || loginId.isEmpty()) {
	        redirectAttributes.addFlashAttribute("error", "로그인을 먼저 해주세요.");
	        return "redirect:/login";
	    }
		
	    map.put("loginId", loginId); // 로그인된 사용자 ID를 추가
		int boardContSeq = this.BoardService.create(map);
		return "redirect:/read/" + String.valueOf(boardContSeq);
	}

	/* 게시판 글 읽기 화면 렌더링 */
	@RequestMapping(value="/read/{boardContSeq}", method = RequestMethod.GET)
	public String getRead(@PathVariable("boardContSeq") int boardContSeq, Model model) {
		Map<String, Object> boardContent = this.BoardService.read(boardContSeq);
		model.addAttribute("boardContent", boardContent);
		return "board/read";
	}

	/* 글 수정하기 */
	@RequestMapping(value="/read/{boardContSeq}", method=RequestMethod.POST)
	public String putEdit(EditRequestVO editRequestVO) {
		boolean isSuccessEdit = this.BoardService.edit(editRequestVO);
		if (isSuccessEdit) {
			return "redirect:/read/" + String.valueOf(editRequestVO.getBoardContSeq());
		} 
		return "redirect:/list";
	}
	
	@DeleteMapping(value = "/delete")
	public String delete(int boardContSeq) {
		this.BoardService.delete(boardContSeq);
		return "redirect:/";
	}
	
	/* 전체 메인 화면 */
	@GetMapping("/")
	public String list(ListRequestVO listRequestVO, Model model) {
		logger.info("Search Term: {}", listRequestVO.getSearch());
        
        List<ListResponseVO> listResponseVOList = this.BoardService.list(listRequestVO);
		logger.info("List Response: {}", listResponseVOList);
        
        model.addAttribute("listRequestVO", listRequestVO);
        model.addAttribute("listResponseVOList", listResponseVOList);
        return "/board/list";
	}
}
