package mytld.mycompany.myapp.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mytld.mycompany.myapp.board.service.BoardService;
import mytld.mycompany.myapp.board.vo.EditRequestVO;

@Controller
public class BoardController {

	@Autowired
	BoardService BoardService;
	
	/* 글 쓰기 화면 렌더링 */
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String getCreate(Locale locale, Model model) {
		
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
	public String postCreate(@RequestParam Map<String, Object> map) {
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
	
	
	
	
	/* 메인으로 나오는 전체 글 목록 페이지 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getList() {
		return "board/list";
	}

	
}
