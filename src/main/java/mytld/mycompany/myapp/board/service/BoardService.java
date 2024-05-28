package mytld.mycompany.myapp.board.service;

import java.util.List;
import java.util.Map;

import mytld.mycompany.myapp.board.vo.EditRequestVO;
import mytld.mycompany.myapp.board.vo.ListRequestVO;
import mytld.mycompany.myapp.board.vo.ListResponseVO;

public interface BoardService {
	int create(Map<String, Object> map);
	int getNextSeqBoard();
	Map<String, Object> read(int blogContSeq);
	boolean edit(EditRequestVO editRequestVO);
	boolean delete(int boardContSeq);
	List<ListResponseVO> list(ListRequestVO listRequestVO);

}
