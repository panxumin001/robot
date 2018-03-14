package com.germaine.recureRobot.service;

import com.germaine.recureRobot.entity.RobotGaitEntity;

public interface RobotGaitService {
    RobotGaitEntity getRobotGaitEntityByMobile(String mobile);

    public int add(RobotGaitEntity entity);

    public int update(RobotGaitEntity entity);
}
