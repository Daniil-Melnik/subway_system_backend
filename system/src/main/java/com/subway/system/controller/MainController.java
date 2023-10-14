package com.subway.system.controller;

import org.springframework.web.bind.annotation.*;

import com.subway.system.DataBase;
import com.subway.system.Para;
import com.subway.system.Photo;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class MainController {

    @GetMapping("/getPhotos")
    public List<Photo> list_photo(){
        return DataBase.getPhotoByStID(1);
    }
    
    @GetMapping("/getParas")
    public List<Para> list_para(){
        return DataBase.getParaByStID(1);
    } 
}
