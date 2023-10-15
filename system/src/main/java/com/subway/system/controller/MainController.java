package com.subway.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.subway.system.model.Line;
import com.subway.system.model.Para;
import com.subway.system.model.Photo;
import com.subway.system.model.Station;
import com.subway.system.service.LineService;
import com.subway.system.service.ParaService;
import com.subway.system.service.PhotoService;
import com.subway.system.service.StationService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class MainController {
    @Autowired
    private ParaService paraService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private StationService stationService;

    @Autowired
    private LineService lineService;

    @PostMapping("/add")
    public String add(@RequestBody Para para){
        paraService.savePara(para);
        return "New student is added";
    }

    @GetMapping("/getParas")
    public List<Para> listPara(){
        List<Para> list = paraService.getAllParas();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
        return paraService.getAllParas();
    }

    @GetMapping("/getPhotos")
    public List<Photo> listPhoto(){
        return photoService.getAllPhotos();
    }

    @GetMapping("/getStations")
    public List<Station> listStation(){
        return stationService.getAllStations();
    }

    @GetMapping("/getLines")
    public List<Line> listLine(){
        return lineService.getAllLines();
    }
}
