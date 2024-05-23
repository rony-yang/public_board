package mytld.mycompany.myapp.board.vo;

public class EditRequestVO {
	private int boardContSeq;
	private String title;
	private String content_body;
	/*JSP에서 전송하는 폼 데이터의 이름, VO 클래스의 필드 이름, 그리고 MyBatis SQL 맵퍼에서 사용하는 파라미터 이름은 모두 일치해야 함*/
	
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

}
