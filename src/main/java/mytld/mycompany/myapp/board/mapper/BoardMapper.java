package mytld.mycompany.myapp.board.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	int delete(int boardContSeq); /* 매퍼SQL에서 정의한 id와 메서드 이름이 같아야함 */

}
