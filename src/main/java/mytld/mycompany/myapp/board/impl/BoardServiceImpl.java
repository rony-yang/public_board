package mytld.mycompany.myapp.board.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mytld.mycompany.myapp.board.dao.BoardDAO;
import mytld.mycompany.myapp.board.service.BoardService;
import mytld.mycompany.myapp.board.vo.EditRequestVO;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDAO BoardDAO;

	@Autowired
	public BoardServiceImpl(BoardDAO BoardDAO) {
	this.BoardDAO = BoardDAO;
	}

	@Override
	public int create(Map<String, Object> map) {
		int seq = this.BoardDAO.insert(map);
		return seq;
	}

	@Override
	public int getNextSeqBoard() {
		return BoardDAO.getNextSeqBoard();
	}

	@Override
	public Map<String, Object> read(int boardContSeq) {
		Map<String, Object> boardCont = this.BoardDAO.selectOne(boardContSeq);
		return boardCont;
	}

	@Override
	public boolean edit(EditRequestVO editRequestVO) {
		int affectRowsCount = this.BoardDAO.update(editRequestVO);
		return affectRowsCount > 0;
	}

}
