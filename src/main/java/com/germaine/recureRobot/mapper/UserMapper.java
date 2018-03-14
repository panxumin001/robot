package com.germaine.recureRobot.mapper;

import com.germaine.recureRobot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE mobile = #{mobile}")
    @Results({
            @Result(property = "socialSecurityNo",  column = "social_security_no"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "totalTrainingTime", column = "total_training_time")
    })
    User getUserByMobile(String mobile);

    @Select("SELECT * FROM users")
    public List<User> getUserList();

    @Insert("insert into users(mobile, socialSecurityNo, userName, nickName, passWord, gender, age, totalTrainingTime) values(#{user.mobile}, #{user.socialSecurityNo}, #{user.userName},#{user.nickName},#{user.passWord},#{user.gender},#{user.age},#{user.totalTrainingTime})")
    public int add(User user);

    @Update("UPDATE users SET userName = #{user.socialSecurityNo} , age = #{user.age} WHERE mobile = #{mobile}")
    public int update(@Param("mobile") String mobile, @Param("user") User user);

    @Delete("DELETE from users where mobile = #{mobile} ")
    public int delete(String mobile);
}
