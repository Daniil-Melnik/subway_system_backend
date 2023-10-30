package com.subway.system.service;

import java.util.List;

import com.subway.system.model.Photo;

public interface PhotoService {
    public Photo savePhoto(Photo photo);
    public List<Photo> getAllPhotos();
    public List<Photo> getPhotosByStID(int n);
}