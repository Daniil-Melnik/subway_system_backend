package com.subway.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.subway.system.model.Para;
import com.subway.system.service.ParaService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class MainController {
    @Autowired
    private ParaService paraService;

    @PostMapping("/add")
    public String add(@RequestBody Para para){
        paraService.savePara(para);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Para> list(){
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ\nQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ\nQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ\nQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
        List<Para> list = paraService.getAllParas();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
        return paraService.getAllParas();
    }
}
