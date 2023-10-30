package com.subway.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.subway.system.model.Line;
import com.subway.system.model.Para;
import com.subway.system.model.Photo;
import com.subway.system.model.Station;
import com.subway.system.model.User;
import com.subway.system.repository.ParaRepository;
import com.subway.system.service.LineService;
import com.subway.system.service.ParaService;
import com.subway.system.service.PhotoService;
import com.subway.system.service.StationService;
import com.subway.system.service.UserService;
import com.subway.system.util_classes.Article_Section;
import com.subway.system.util_classes.Localed_Station;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private UserService userService;

    @Autowired
    private ParaRepository paraRepo;

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New user is added";
    }

    @GetMapping("/getParas")
    public List<Para> listPara(){
        List<Para> list = paraRepo.findBystNum(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
        return paraService.getParasByStID(1);
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

        List<Para> paraList = paraService.getParasByStID(station_id);
        List<Photo> photoList = photoService.getPhotosByStID(station_id);

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
    public Optional<Station> StationList(@PathVariable(value = "id") int station_id){
        return stationService.getStationByID(station_id);
    }

    @GetMapping("/getUser/{email}/{psw}")
    public User UserAuth(@PathVariable(value = "email") String email, @PathVariable(value = "psw") String psw){
        List<User> usList = userService.getAllUsers();
        User f_us = new User("no_email", "000", 0, 0);
        for (int i = 0; i < usList.size(); i++){
            User us = usList.get(i);
            if (us.getEmail().equals(email) & us.getPsw().equals(psw)){
                f_us = us;
            }
        }
        return f_us;
    }
}

