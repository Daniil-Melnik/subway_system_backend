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
import com.subway.system.util_classes.Article_Section;
import com.subway.system.util_classes.Localed_Station;

import java.util.ArrayList;
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

    @GetMapping("/getStations/{locale}")
    public List<Localed_Station> listStation(@PathVariable(value = "locale") String local){
        List<Localed_Station> res = new ArrayList<>();
        List<Station> stations = stationService.getAllStations();

        for (int i = 0; i < stations.size(); i++) {
            Station st = stations.get(i);
            Localed_Station l_st = new Localed_Station(st.getId(), st.getName(), st.getNum_of_sec(), st.getLine_id());
            if (local.equals("en")){
                l_st.setName(st.getNameEn());
            }
            res.add(l_st);
        }
        return res;
    }

    @GetMapping("/getLines")
    public List<Line> listLine(){
        return lineService.getAllLines();
    }

    @GetMapping("/getArticle/{id}/{locale}")
    public List<Article_Section> listSection(@PathVariable(value = "id") int station_id, @PathVariable(value = "locale") String local){
        List<Article_Section> list = new ArrayList<>();

        List<Para> allParaList = paraService.getAllParas();
        List<Photo> allPhotoList = photoService.getAllPhotos();

        List<Para> paraList = new ArrayList<>();
        List<Photo> photoList = new ArrayList<>();

        for (int i = 0; i < allParaList.size(); i++) {
            Para para = allParaList.get(i);
            if (para.getStation_id() == station_id) {
                paraList.add(para);
            }
        }

        for (int i = 0; i < allPhotoList.size(); i++) {
            Photo photo = allPhotoList.get(i);
            if (photo.getStation_id() == station_id) {
                photoList.add(photo);
            }
        }

        for (int i = 0; i < paraList.size(); i++){

            Para para = paraList.get(i);
            Photo photo = photoList.get(i);
            
            if (local.equals("en")){
                list.add(new Article_Section(para.getTextEn(), photo.getSrc(), photo.getCaptionEn(), para.getSection_num()));
            }
            if (local.equals("ru")){
                list.add(new Article_Section(para.getText(), photo.getSrc(), photo.getCaption(), para.getSection_num()));
            }
            
        }

        return list;
    }

    @GetMapping("/getStation/{id}")
    public Station StationList(@PathVariable(value = "id") int station_id){
        List<Station> stList = stationService.getAllStations();
        Station f_st = new Station();
        for (int i = 0; i < stList.size(); i++){
            Station st = stList.get(i);
            if (st.getId() == station_id){
                f_st = st;
            }
        }
        return f_st;
    }
}

