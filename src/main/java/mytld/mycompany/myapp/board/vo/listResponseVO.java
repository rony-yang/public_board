package mytld.mycompany.myapp.board.vo;

import java.time.LocalDateTime;

public class listResponseVO {
	private int seq_board;
	private String title;
	private String contents;
	private LocalDateTime board_date;
	private String board_id;
	public int getSeq_board() {
		return seq_board;
	}
	public void setSeq_board(int seq_board) {
		this.seq_board = seq_board;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public LocalDateTime getBoard_date() {
		return board_date;
	}
	public void setBoard_date(LocalDateTime board_date) {
		this.board_date = board_date;
	}
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
}
