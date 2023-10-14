package com.subway.system.controller;

import org.springframework.web.bind.annotation.*;

import com.subway.system.DataBase;
import com.subway.system.Photo;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class MainController {

    @GetMapping("/getPhotos")
    public List<Photo> list(){
        return DataBase.getPhotoByStID(1);
    } 
}
