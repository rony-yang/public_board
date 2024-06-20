package mytld.mycompany.myapp.board.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mytld.mycompany.myapp.board.dao.MemberDAO;
import mytld.mycompany.myapp.board.mapper.MemberMapper;
import mytld.mycompany.myapp.board.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
    @Autowired
    private MemberMapper memberMapper;

	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public int register(Map<String, Object> map) {
		int seq = this.memberDAO.memberInsert(map);
		return seq;
	}

	@Override
	public boolean checkDuplicate(String id) {
        Map<String, Object> result = memberMapper.idDuplicate(id);
        return result == null || result.isEmpty();
	}

	
}
