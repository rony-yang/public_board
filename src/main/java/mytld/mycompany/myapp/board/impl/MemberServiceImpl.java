package mytld.mycompany.myapp.board.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mytld.mycompany.myapp.board.dao.MemberDAO;
import mytld.mycompany.myapp.board.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;

	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public int register(Map<String, Object> map) {
		int seq = this.memberDAO.memberInsert(map);
		return seq;
	}

	
}
