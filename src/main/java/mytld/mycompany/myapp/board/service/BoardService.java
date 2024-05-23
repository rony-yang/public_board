package mytld.mycompany.myapp.board.service;

import java.util.Map;

public interface BoardService {
	int create(Map<String, Object> map);
	int getNextSeqBoard();
	Map<String, Object> read(int blogContSeq);

}
