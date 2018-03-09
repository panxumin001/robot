package com.germaine.recureRobot.entity;

import java.io.Serializable;

public class RobotGaitEntity implements Serializable{

    private String userSocialSecurityNo; // 用户社保id
    private String stepAmplitude; // 步幅
    private String stepWidth; // 步宽
    private String stepFrequency; // 步频
    private String stepLength; //步长
    private String leftHipAngle; //左髋关节角度
    private String leftKneeAngle; //左膝关节角度
    private String leftToePressure; //左脚尖压力
    private String leftHeelPressure; //左脚跟压力
    private String rightHipAngle; //右髋关节角度
    private String rightKneeAngle; //右膝关节角度
    private String rightToePressure; //右脚尖压力
    private String rightHeelPressure; //右脚跟压力

    public RobotGaitEntity(String userSocialSecurityNo, String stepAmplitude, String stepWidth, String stepFrequency, String stepLength, String leftHipAngle, String leftKneeAngle, String leftToePressure, String leftHeelPressure, String rightHipAngle, String rightKneeAngle, String rightToePressure, String rightHeelPressure) {
        this.userSocialSecurityNo = userSocialSecurityNo;
        this.stepAmplitude = stepAmplitude;
        this.stepWidth = stepWidth;
        this.stepFrequency = stepFrequency;
        this.stepLength = stepLength;
        this.leftHipAngle = leftHipAngle;
        this.leftKneeAngle = leftKneeAngle;
        this.leftToePressure = leftToePressure;
        this.leftHeelPressure = leftHeelPressure;
        this.rightHipAngle = rightHipAngle;
        this.rightKneeAngle = rightKneeAngle;
        this.rightToePressure = rightToePressure;
        this.rightHeelPressure = rightHeelPressure;
    }

    public RobotGaitEntity() {
    }

    public String getUserSocialSecurityNo() {
        return userSocialSecurityNo;
    }

    public void setUserSocialSecurityNo(String userSocialSecurityNo) {
        this.userSocialSecurityNo = userSocialSecurityNo;
    }

    public String getStepAmplitude() {
        return stepAmplitude;
    }

    public void setStepAmplitude(String stepAmplitude) {
        this.stepAmplitude = stepAmplitude;
    }

    public String getStepWidth() {
        return stepWidth;
    }

    public void setStepWidth(String stepWidth) {
        this.stepWidth = stepWidth;
    }

    public String getStepFrequency() {
        return stepFrequency;
    }

    public void setStepFrequency(String stepFrequency) {
        this.stepFrequency = stepFrequency;
    }

    public String getStepLength() {
        return stepLength;
    }

    public void setStepLength(String stepLength) {
        this.stepLength = stepLength;
    }

    public String getLeftHipAngle() {
        return leftHipAngle;
    }

    public void setLeftHipAngle(String leftHipAngle) {
        this.leftHipAngle = leftHipAngle;
    }

    public String getLeftKneeAngle() {
        return leftKneeAngle;
    }

    public void setLeftKneeAngle(String leftKneeAngle) {
        this.leftKneeAngle = leftKneeAngle;
    }

    public String getLeftToePressure() {
        return leftToePressure;
    }

    public void setLeftToePressure(String leftToePressure) {
        this.leftToePressure = leftToePressure;
    }

    public String getLeftHeelPressure() {
        return leftHeelPressure;
    }

    public void setLeftHeelPressure(String leftHeelPressure) {
        this.leftHeelPressure = leftHeelPressure;
    }

    public String getRightHipAngle() {
        return rightHipAngle;
    }

    public void setRightHipAngle(String rightHipAngle) {
        this.rightHipAngle = rightHipAngle;
    }

    public String getRightKneeAngle() {
        return rightKneeAngle;
    }

    public void setRightKneeAngle(String rightKneeAngle) {
        this.rightKneeAngle = rightKneeAngle;
    }

    public String getRightToePressure() {
        return rightToePressure;
    }

    public void setRightToePressure(String rightToePressure) {
        this.rightToePressure = rightToePressure;
    }

    public String getRightHeelPressure() {
        return rightHeelPressure;
    }

    public void setRightHeelPressure(String rightHeelPressure) {
        this.rightHeelPressure = rightHeelPressure;
    }

    @Override
    public String toString() {
        return "RobotGaitEntity{" +
                "stepAmplitude='" + stepAmplitude + '\'' +
                ", stepWidth='" + stepWidth + '\'' +
                ", stepFrequency='" + stepFrequency + '\'' +
                ", stepLength='" + stepLength + '\'' +
                ", leftHipAngle='" + leftHipAngle + '\'' +
                ", leftKneeAngle='" + leftKneeAngle + '\'' +
                ", leftToePressure='" + leftToePressure + '\'' +
                ", leftHeelPressure='" + leftHeelPressure + '\'' +
                ", rightHipAngle='" + rightHipAngle + '\'' +
                ", rightKneeAngle='" + rightKneeAngle + '\'' +
                ", rightToePressure='" + rightToePressure + '\'' +
                ", rightHeelPressure='" + rightHeelPressure + '\'' +
                '}';
    }
}
