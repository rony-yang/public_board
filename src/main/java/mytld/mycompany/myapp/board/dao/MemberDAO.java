package mytld.mycompany.myapp.board.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* 회원가입 페이지 */
	public int memberInsert(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.insert("member_register.member_insert",map); /* MEMBER_SQL.xml에서 namespace와 id 가져오기 */
		
		if (result > 0 && map.containsKey("seq_member")) { /* MEMBER_SQL.xml에서 keyProperty 가져오기 */
			return (Integer) map.get("seq_member");
		}
		return -1;
	}

}
