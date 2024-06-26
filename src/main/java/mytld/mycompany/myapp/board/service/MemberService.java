package mytld.mycompany.myapp.board.service;

import java.util.Map;

public interface MemberService {
	int register(Map<String, Object> map);
	boolean checkDuplicate(String id);
}
