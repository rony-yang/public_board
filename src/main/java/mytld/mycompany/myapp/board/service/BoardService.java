package mytld.mycompany.myapp.board.service;

import java.util.Map;

import mytld.mycompany.myapp.board.vo.EditRequestVO;

public interface BoardService {
	int create(Map<String, Object> map);
	int getNextSeqBoard();
	Map<String, Object> read(int blogContSeq);
	boolean edit(EditRequestVO editRequestVO);

}
