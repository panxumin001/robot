package com.germaine.recureRobot.service;

import com.germaine.recureRobot.entity.RobotGaitEntity;

public interface RobotGaitService {
    RobotGaitEntity getRobotGaitEntityById(Integer id);

    public int add(RobotGaitEntity entity);
}
