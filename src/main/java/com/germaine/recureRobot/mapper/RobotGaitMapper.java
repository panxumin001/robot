package com.germaine.recureRobot.mapper;

import com.germaine.recureRobot.entity.RobotGaitEntity;
import org.apache.ibatis.annotations.*;

public interface RobotGaitMapper {

    @Select("SELECT * FROM robot_gait_attribute WHERE mobile = #{mobile}")
    @Results({
            @Result(property = "socialSecurityNo", column = "social_security_no"),
            @Result(property = "stepAmplitude", column = "step_amplitude"),
            @Result(property = "stepWidth", column = "step_width"),
            @Result(property = "stepFrequency", column = "step_frequency"),
            @Result(property = "stepLength", column = "step_length"),
            @Result(property = "leftHipAngle", column = "left_hip_angle"),
            @Result(property = "leftKneeAngle", column = "left_knee_angle"),
            @Result(property = "leftToePressure", column = "left_toe_pressure"),
            @Result(property = "leftHeelPressure", column = "left_heel_pressure"),
            @Result(property = "rightHipAngle", column = "right_hip_angle"),
            @Result(property = "rightKneeAngle", column = "right_knee_angle"),
            @Result(property = "rightToePressure", column = "right_toe_pressure"),
            @Result(property = "rightHeelPressure", column = "right_heel_pressure")
    })
    RobotGaitEntity getRobotGaitEntityByMobile(String mobile);

    @Insert("insert into robot_gait_attribute(mobile, social_security_no, step_amplitude, step_width, step_frequency, step_length, left_hip_angle, left_knee_angle, left_toe_pressure, " +
            "left_heel_pressure, right_hip_angle, right_knee_angle, right_toe_pressure, right_heel_pressure) " +
            "values(#{mobile}, #{socialSecurityNo}, #{stepAmplitude}, #{stepWidth}, #{stepFrequency}, #{stepLength}, #{leftHipAngle}, #{leftKneeAngle}, #{leftToePressure}, " +
            "#{leftHeelPressure}, #{rightHipAngle}, #{rightKneeAngle}, #{rightToePressure}, #{rightHeelPressure})")
    int add(RobotGaitEntity entity);

    @Update("update robot_gait_attribute set step_amplitude = #{stepAmplitude}, step_width = #{stepWidth}, step_frequency = #{stepFrequency}, step_length = #{stepLength}, " +
            "left_hip_angle = #{leftHipAngle}, left_knee_angle = #{leftKneeAngle}, left_toe_pressure = #{leftToePressure}, left_heel_pressure = #{leftHeelPressure}, " +
            "right_hip_angle = #{rightHipAngle}, right_knee_angle = #{rightKneeAngle}, right_toe_pressure = #{rightToePressure}, right_heel_pressure = #{rightHeelPressure} where mobile = #{mobile}")
    int update(RobotGaitEntity entity);
}
