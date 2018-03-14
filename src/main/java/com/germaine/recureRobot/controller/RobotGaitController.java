package com.germaine.recureRobot.controller;

import com.germaine.recureRobot.entity.JsonResult;
import com.germaine.recureRobot.entity.RobotGaitEntity;
import com.germaine.recureRobot.service.RobotGaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gateway")
public class RobotGaitController {

    @Autowired
    private RobotGaitService robotGaitService;

    /**
     * 初始化骨骼参数信息
     * @param entity
     * @return
     */
    @RequestMapping(value = "/initGaitData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JsonResult> initGaitData(@RequestBody RobotGaitEntity entity) {
        JsonResult r = new JsonResult();
        try {
            int orderId = robotGaitService.add(entity);
            if (orderId < 0) {
                r.setResult(orderId);
                r.setStatus("fail");
            } else {
                r.setResult(orderId);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 更新骨骼参数信息
     * @param entity
     * @return
     */
    @RequestMapping(value = "/updateGaitData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JsonResult> updateGaitData(@RequestBody RobotGaitEntity entity) {
        JsonResult r = new JsonResult();
        try {
            int updateId = robotGaitService.update(entity);
            if (updateId < 0) {
                r.setStatus("fail");
                r.setResult(updateId);
            } else {
                r.setResult(updateId);
                r.setStatus("error");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据mobile查询用户对应骨骼参数信息
     * @param mobile
     * @return
     */
    @RequestMapping(value = "robot/{mobile}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getRobotGaitEntityById (@PathVariable(value = "mobile") String mobile){
        JsonResult r = new JsonResult();
        try {
            RobotGaitEntity entity = robotGaitService.getRobotGaitEntityByMobile(mobile);
            r.setResult(entity);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
