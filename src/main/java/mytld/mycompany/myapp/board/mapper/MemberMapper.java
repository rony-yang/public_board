package mytld.mycompany.myapp.board.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Map<String, Object> idDuplicate(String id);
}
