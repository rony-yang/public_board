package mytld.mycompany.myapp.board.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; /* db-context.xml에 빈으로 등록되어 있어서 사용 가능 */
	
	/* 글 작성 페이지 */
	public int insert(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.insert("board_insert.insert",map); /* BOARD_SQL.xml에서 namespace와 id 가져오기 */
		
		if (result > 0 && map.containsKey("seq_board")) { /* BOARD_SQL.xml에서 keyProperty 가져오기 */
			return (Integer) map.get("seq_board");
		}
		return -1;
	}

	/* 글 작성 페이지 렌더링 시 시퀀스 번호 받아오기 */
	public int getNextSeqBoard() {
		int lastSeqBoard = this.sqlSessionTemplate.selectOne("board_insert.getNextSeqBoard");
		return lastSeqBoard + 1; /* 마지막 시퀀스 값 +1을 반환 */
	}

	public Map<String, Object> selectOne(int boardContSeq) {
		return this.sqlSessionTemplate.selectOne("board_insert.selectOne", boardContSeq);
	}
	
	
}
