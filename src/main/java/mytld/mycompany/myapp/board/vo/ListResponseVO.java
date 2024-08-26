package mytld.mycompany.myapp.board.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ListResponseVO {
	private int boardContSeq;
	private String title;
	private String content_body;
	private String board_id;
	
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	private LocalDateTime insertDt;
	
	public LocalDateTime getInsertDt() {
		return insertDt;
	}
	public void setInsertDt(LocalDateTime insertDt) {
		this.insertDt = insertDt;
	}
	public int getBoardContSeq() {
		return boardContSeq;
	}
	public void setBoardContSeq(int boardContSeq) {
		this.boardContSeq = boardContSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent_body() {
		return content_body;
	}
	public void setContent_body(String content_body) {
		this.content_body = content_body;
	}
	
	public String getInsertDtFormat() {
		return this.insertDt.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 EEEE"));
	}
}
