package mytld.mycompany.myapp.board.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mytld.mycompany.myapp.board.dao.BoardDAO;
import mytld.mycompany.myapp.board.mapper.BoardMapper;
import mytld.mycompany.myapp.board.service.BoardService;
import mytld.mycompany.myapp.board.vo.EditRequestVO;
import mytld.mycompany.myapp.board.vo.ListRequestVO;
import mytld.mycompany.myapp.board.vo.ListResponseVO;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;
	private BoardMapper boardMapper;

	@Autowired
	public BoardServiceImpl(BoardDAO BoardDAO, BoardMapper boardMapper) {
		this.boardDAO = BoardDAO;
		this.boardMapper = boardMapper;
	}

	@Override
	public int create(Map<String, Object> map) {
		int seq = this.boardDAO.insert(map);
		return seq;
	}

	@Override
	public int getNextSeqBoard() {
		return boardDAO.getNextSeqBoard();
	}

	@Override
	public Map<String, Object> read(int boardContSeq) {
		Map<String, Object> boardCont = this.boardDAO.selectOne(boardContSeq);
		return boardCont;
	}

	@Override
	public boolean edit(EditRequestVO editRequestVO) {
		int affectRowsCount = this.boardDAO.update(editRequestVO);
		return affectRowsCount > 0;
	}
	
	@Override
	public boolean delete(int boardContSeq) {
		return this.boardMapper.delete(boardContSeq) > 0;
	}

	@Override
	public List<ListResponseVO> list(ListRequestVO listRequestVO) {
		List<ListResponseVO> result = this.boardMapper.selectList(listRequestVO);
		return result;
	}
	
}
