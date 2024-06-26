package mytld.mycompany.myapp.board.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mytld.mycompany.myapp.board.controller.MemberController;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAO.class);
	
	/* 회원가입 페이지 */
	public int memberInsert(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.insert("mytld.mycompany.myapp.board.mapper.MemberMapper.member_insert",map); /* MEMBER_SQL.xml에서 namespace와 id 가져오기 */
		if (result > 0 && map.containsKey("seq_member")) { /* MEMBER_SQL.xml에서 keyProperty 가져오기 */
			return (Integer) map.get("seq_member");
		}
		return -1;
	}
	
	/* 로그인 */
	public int login(Map<String, Object> map) {
        try {
            int result = sqlSessionTemplate.selectOne("mytld.mycompany.myapp.board.mapper.MemberMapper.loginConfirm", map);
            return result; 
        } catch (Exception e) {
            logger.error("Error during login", e);
            return -1;
        }
	}

}
