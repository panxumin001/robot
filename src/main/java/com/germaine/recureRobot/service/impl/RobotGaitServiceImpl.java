package com.germaine.recureRobot.service.impl;

import com.germaine.recureRobot.entity.RobotGaitEntity;
import com.germaine.recureRobot.mapper.RobotGaitBakMapper;
import com.germaine.recureRobot.mapper.RobotGaitMapper;
import com.germaine.recureRobot.service.RobotGaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotGaitServiceImpl implements RobotGaitService {

    @Autowired
    private RobotGaitMapper robotGaitMapper;

    @Autowired
    private RobotGaitBakMapper robotGaitBakMapper;

    @Override
    public RobotGaitEntity getRobotGaitEntityByMobile(String mobile) {
        return robotGaitMapper.getRobotGaitEntityByMobile(mobile);
    }

    @Override
    public int add(RobotGaitEntity entity) {
        return robotGaitMapper.add(entity);
    }

    @Override
    public int update(RobotGaitEntity entity) {return robotGaitMapper.update(entity);}

    @Override
    public int saveBak(RobotGaitEntity entity) { return robotGaitBakMapper.saveBak(entity);}
}
