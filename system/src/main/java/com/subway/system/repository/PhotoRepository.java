package com.subway.system.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subway.system.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Integer> {
    List<Photo> findBystNum(int n);
}