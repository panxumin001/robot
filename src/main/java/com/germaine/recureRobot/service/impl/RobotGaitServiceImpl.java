package com.germaine.recureRobot.service.impl;

import com.germaine.recureRobot.entity.RobotGaitEntity;
import com.germaine.recureRobot.mapper.RobotGaitMapper;
import com.germaine.recureRobot.service.RobotGaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotGaitServiceImpl implements RobotGaitService {

    @Autowired
    private RobotGaitMapper robotGaitMapper;

    @Override
    public RobotGaitEntity getRobotGaitEntityById(Integer id) {
        return robotGaitMapper.getRobotGaitEntityById(id);
    }

    @Override
    public int add(RobotGaitEntity entity) {
        return robotGaitMapper.add(entity);
    }
}
