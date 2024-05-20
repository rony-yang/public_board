package mytld.mycompany.myapp.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	/* @Autowired */
	/* private JdbcTemplate jdbcTemplate; */
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String getCreate(Locale locale, Model model) {
		
		// 날짜 가져오기
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 EEEE", locale);
		String formattedDate = dateFormat.format(date);
		
        // 마지막 글 번호 시퀀스 값을 가져와서 1을 더한 값을 계산
		/*
		 * String max_sql = "SELECT NVL(MAX(seq_board), 0) + 1 FROM BOARD"; Integer
		 * nextSeqBoard = jdbcTemplate.queryForObject(max_sql, Integer.class);
		 */
		
		model.addAttribute("serverTime", formattedDate);
		/* model.addAttribute("nextSeqBoard", nextSeqBoard); */
        
		return "board/create";
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getList() {
		return "board/list";
	}

	
}
