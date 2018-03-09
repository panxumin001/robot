package com.germaine.recureRobot.mapper;

import com.germaine.recureRobot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(Integer id);

    @Select("SELECT * FROM users")
    public List<User> getUserList();

    @Insert("insert into users(socialSecurityNo, userName, nickName, passWord, gender, age, totalTrainingTime) values(#{user.socialSecurityNo}, #{user.userName},#{user.nickName},#{user.passWord},#{user.gender},#{user.age},#{user.totalTrainingTime})")
    public int add(User user);

    @Update("UPDATE users SET userName = #{user.socialSecurityNo} , age = #{user.age} WHERE id = #{id}")
    public int update(@Param("id") Integer id, @Param("user") User user);

    @Delete("DELETE from users where id = #{id} ")
    public int delete(Integer id);
}
