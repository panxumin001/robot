package com.germaine.recureRobot.mapper;

import com.germaine.recureRobot.entity.RobotGaitEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface RobotGaitMapper {

    @Select("SELECT * FROM robot_gait_entity WHERE id = #{id}")
    RobotGaitEntity getRobotGaitEntityById(Integer id);

    @Insert("insert into robot_gait_entity(userSocialSecurityNo, stepAmplitude, stepWidth, stepFrequency, stepLength, leftHipAngle, leftKneeAngle, leftToePressure, leftHeelPressure, rightHipAngle, rightKneeAngle, rightToePressure, rightHeelPressure) " +
            "values(#{entity.userSocialSecurityNo}, #{entity.stepAmplitude}, #{entity.stepWidth}, #{entity.stepFrequency}, #{entity.stepLength}, #{entity.leftHipAngle}, #{entity.leftKneeAngle}, #{entity.leftToePressure}, #{entity.leftHeelPressure}, #{entity.rightHipAngle}, #{entity.rightKneeAngle}, #{entity.rightToePressure}, #{entity.rightHeelPressure})")
    public int add(RobotGaitEntity entity);
}
