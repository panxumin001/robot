CREATE DATABASE robotdb;
USE
    robotdb;
DROP TABLE IF EXISTS
    `users`;
CREATE TABLE `users`(
    `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `mobile` VARCHAR(32) NOT NULL UNIQUE COMMENT '患者手机号',
    `social_security_no` VARCHAR(32) UNIQUE COMMENT '用户社保号',
    `user_name` VARCHAR(32) COMMENT '用户名',
    `nick_name` VARCHAR(32) COMMENT '昵称',
    `passWord` VARCHAR(32) COMMENT '密码',
    `gender` VARCHAR(32) COMMENT '性别',
    `age` INT COMMENT '年龄',
    `total_training_time` INT COMMENT '训练总时长',
    `create_time` datetime  not null  default CURRENT_TIMESTAMP  comment '创建时间',
    `update_time` datetime  not null default CURRENT_TIMESTAMP  comment '修改时间',
    PRIMARY KEY(`user_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
DROP TABLE IF EXISTS
    `robot_gait_attribute`;
CREATE TABLE `robot_gait_attribute`(
    `attribute_id` INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `mobile` VARCHAR(32) UNIQUE COMMENT '患者手机号',
    `social_security_no` VARCHAR(32) COMMENT '用户社保号',
    `step_amplitude` VARCHAR(32) DEFAULT "" COMMENT '步幅',
    `step_width` VARCHAR(32) DEFAULT "" COMMENT '步宽',
    `step_frequency` VARCHAR(32) DEFAULT "" COMMENT '步频',
    `step_length` VARCHAR(32) DEFAULT "" COMMENT '步长',
    `left_hip_angle` VARCHAR(32) DEFAULT "" COMMENT '左髋关节角度',
    `left_knee_angle` VARCHAR(32) DEFAULT "" COMMENT '左膝关节角度',
    `left_toe_pressure` VARCHAR(32) DEFAULT "" COMMENT '左脚尖压力',
    `left_heel_pressure` VARCHAR(32) DEFAULT "" COMMENT '左脚跟压力',
    `right_hip_angle` VARCHAR(32) DEFAULT "" COMMENT '右髋关节角度',
    `right_knee_angle` VARCHAR(32) DEFAULT "" COMMENT '右膝关节角度',
    `right_toe_pressure` VARCHAR(32) DEFAULT "" COMMENT '右脚尖压力',
    `right_heel_pressure` VARCHAR(32) DEFAULT "" COMMENT '右脚跟压力',
    `create_time` datetime  not null  default CURRENT_TIMESTAMP  comment '创建时间',
    `update_time` datetime  not null default CURRENT_TIMESTAMP  comment '修改时间',
    PRIMARY KEY(`attribute_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
DROP TABLE IF EXISTS
    `robot_gait_attribute_bak`;
CREATE TABLE `robot_gait_attribute_bak`(
    `attribute_bak_id` INT NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `mobile` VARCHAR(32) COMMENT '患者手机号',
    `social_security_no` VARCHAR(32) COMMENT '用户社保号',
    `step_amplitude` VARCHAR(32) DEFAULT "" COMMENT '步幅',
    `step_width` VARCHAR(32) DEFAULT "" COMMENT '步宽',
    `step_frequency` VARCHAR(32) DEFAULT "" COMMENT '步频',
    `step_length` VARCHAR(32) DEFAULT "" COMMENT '步长',
    `left_hip_angle` VARCHAR(32) DEFAULT "" COMMENT '左髋关节角度',
    `left_knee_angle` VARCHAR(32) DEFAULT "" COMMENT '左膝关节角度',
    `left_toe_pressure` VARCHAR(32) DEFAULT "" COMMENT '左脚尖压力',
    `left_heel_pressure` VARCHAR(32) DEFAULT "" COMMENT '左脚跟压力',
    `right_hip_angle` VARCHAR(32) DEFAULT "" COMMENT '右髋关节角度',
    `right_knee_angle` VARCHAR(32) DEFAULT "" COMMENT '右膝关节角度',
    `right_toe_pressure` VARCHAR(32) DEFAULT "" COMMENT '右脚尖压力',
    `right_heel_pressure` VARCHAR(32) DEFAULT "" COMMENT '右脚跟压力',
    `create_time` datetime  not null  default CURRENT_TIMESTAMP  comment '创建时间',
    `update_time` datetime  not null default CURRENT_TIMESTAMP  comment '修改时间',
    PRIMARY KEY(`attribute_bak_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;