package com.germaine.recureRobot.mapper;

import com.germaine.recureRobot.entity.RobotGaitEntity;
import org.apache.ibatis.annotations.Insert;

public interface RobotGaitBakMapper {

    @Insert("insert into robot_gait_attribute_bak(mobile, social_security_no, step_amplitude, step_width, step_frequency, step_length, left_hip_angle, left_knee_angle, left_toe_pressure, " +
            "left_heel_pressure, right_hip_angle, right_knee_angle, right_toe_pressure, right_heel_pressure) " +
            "values(#{mobile}, #{socialSecurityNo}, #{stepAmplitude}, #{stepWidth}, #{stepFrequency}, #{stepLength}, #{leftHipAngle}, #{leftKneeAngle}, #{leftToePressure}, " +
            "#{leftHeelPressure}, #{rightHipAngle}, #{rightKneeAngle}, #{rightToePressure}, #{rightHeelPressure})")
    int saveBak(RobotGaitEntity entity);

}
