package com.germaine.recureRobot.controller;

import com.germaine.recureRobot.entity.JsonResult;
import com.germaine.recureRobot.entity.RobotGaitEntity;
import com.germaine.recureRobot.service.RobotGaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gateway")
public class RobotGaitController {

    @Autowired
    private RobotGaitService robotGaitService;

    @RequestMapping(value = "/saveGaitData", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> saveGaitData(@RequestBody RobotGaitEntity entity) {
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
     * 根据ID查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "robot/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getRobotGaitEntityById (@PathVariable(value = "id") Integer id){
        JsonResult r = new JsonResult();
        try {
            RobotGaitEntity entity = robotGaitService.getRobotGaitEntityById(id);
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
