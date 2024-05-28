package mytld.mycompany.myapp.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mytld.mycompany.myapp.board.vo.ListRequestVO;
import mytld.mycompany.myapp.board.vo.ListResponseVO;

@Mapper
public interface BoardMapper {
	int delete(int boardContSeq); /* 매퍼SQL에서 정의한 id와 메서드 이름이 같아야함 */
	List<ListResponseVO> selectList(ListRequestVO listRequestVO);

}
