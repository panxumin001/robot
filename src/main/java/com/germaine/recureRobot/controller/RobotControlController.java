package com.germaine.recureRobot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/control")
public class RobotControlController {

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public ResponseEntity connectToRobot() {
        System.out.println("test````");

        return null;
    }
}
