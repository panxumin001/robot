create dataBase robotdb;
use robotdb;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `mobile` varchar(32) NOT NULL unique COMMENT '患者手机号',
  `social_security_no` varchar(32)  unique COMMENT '用户社保号',
  `user_name` varchar(32)  COMMENT '用户名',
  `nick_name` varchar(32)  COMMENT '昵称',
  `passWord` varchar(32) COMMENT '密码',
  `gender` varchar(32) COMMENT '性别',
  `age` int COMMENT '年龄',
  `total_training_time` int COMMENT '训练总时长',
  `update_time` timestamp not null default current_timestamp,
  PRIMARY KEY (`user_id`))ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `robot_gait_attribute`;
CREATE TABLE `robot_gait_attribute`(
     `attribute_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
     `user_social_security_no` varchar(32) COMMENT '用户信息关联id',
     `step_amplitude` varchar(32) DEFAULT "" COMMENT '步幅',
     `step_width` varchar(32) DEFAULT "" COMMENT '步宽',
     `step_frequency` varchar(32) DEFAULT "" COMMENT '步频',
     `step_length` varchar(32) DEFAULT "" COMMENT '步长',
     `left_hip_angle` varchar(32) DEFAULT "" COMMENT '左髋关节角度',
     `left_knee_angle` varchar(32) DEFAULT "" COMMENT '左膝关节角度',
     `left_toe_pressure` varchar(32) DEFAULT "" COMMENT '左脚尖压力',
     `left_heel_pressure` varchar(32) DEFAULT "" COMMENT '左脚跟压力',
     `right_hip_angle` varchar(32) DEFAULT "" COMMENT '右髋关节角度',
     `right_knee_angle` varchar(32) DEFAULT "" COMMENT '右膝关节角度',
     `right_toe_pressure` varchar(32) DEFAULT "" COMMENT '右脚尖压力',
     `right_heel_pressure` varchar(32) DEFAULT "" COMMENT '右脚跟压力',
     `update_time` timestamp not null default current_timestamp,
     PRIMARY KEY (`attribute_id`))ENGINE=InnoDB DEFAULT CHARSET=utf8;



