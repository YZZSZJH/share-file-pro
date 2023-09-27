package com.lss.sharefile.controller;

import com.lss.sharefile.entity.ShareFile;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lss
 * @Date: 2023/09/21/22:38
 * @Description:
 */
@RestController

public class TestController {
    @PostMapping("/test")
    public String test(@RequestBody ShareFile s){
        System.out.println(s+"-----");
        return s.toString();
    }

    @Autowired
    private FileAlterationMonitor monitor;

    @GetMapping("/test2")
    public String test2() throws Exception {
        monitor.start();
        return "success";
    }
}
