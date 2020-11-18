package springboot.repository;

import org.apache.ibatis.annotations.Mapper;
import springboot.repository.dvo.MemberDVO;

@Mapper
public interface ICoffeeMemberMapper {
    MemberDVO existsByMemberName(MemberDVO memberDVO);
    int createMemberTable();
    int insertMemberData(MemberDVO memberDVO);
}
