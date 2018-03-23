package com.germaine.recureRobot.controller;

import com.germaine.recureRobot.entity.JsonResult;
import com.germaine.recureRobot.entity.RobotGaitEntity;
import com.germaine.recureRobot.service.RobotGaitService;
import com.germaine.recureRobot.tcp.TcpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
            RobotGaitEntity gaitEntity = robotGaitService.getRobotGaitEntityByMobile(entity.getMobile().toString());
            if (StringUtils.isEmpty(gaitEntity)) {
                robotGaitService.add(entity);
                System.out.println("--->新增初始化数据！data:" + entity );
            }
            int bak = robotGaitService.saveBak(entity); // 数据备份表备份
            if (bak <= 0 ) {
                System.out.println("--->数据接收备份失败！data:" + entity );
            } else {
                System.out.println("--->数据接收备份成功！data:" + entity);
            }

            int updateId = robotGaitService.update(entity); // 数据更新
            if (updateId <= 0) {
                r.setStatus("fail");
                r.setResult(updateId);
            } else {
                r.setResult(updateId);
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

    /**
     * 通过tcp协议发送控制指令
     * @param controlOrder
     * @return
     */
    @RequestMapping(value = {"/control"}, produces = "application/json;charset=utf-8", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity robotControl(@RequestParam String controlOrder) {
        JsonResult r = new JsonResult();
        System.out.println("---->controlOrder send begin :" + controlOrder);
        String messege = TcpUtils.sendMessege("192.168.1.117", 80, controlOrder);
        System.out.println("---->controlOrder send end :" + controlOrder);
        r.setStatus("ok");
        r.setResult(messege);
        return ResponseEntity.ok(r);

    }
}
