package yiming.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import yiming.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    @Select("select * from user where user_name like concat('%', #{userName, jdbcType=VARCHAR} '%')")
    User findByUserName(@Param("userName") String userName);
}