package mytld.mycompany.myapp.board.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; /* db-context.xml에 빈으로 등록되어 있어서 사용 가능 */
	
	public int insert(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.insert("board_insert.insert",map); /* BOARD_SQL.xml에서 namespace와 id 가져오기 */
		
		if (result > 0 && map.containsKey("seq_board")) { /* BOARD_SQL.xml에서 keyProperty 가져오기 */
			return (Integer) map.get("seq_board");
		}
		return -1;
	}

}
