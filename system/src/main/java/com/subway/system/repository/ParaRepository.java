package com.subway.system.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subway.system.model.Para;

@Repository
public interface ParaRepository extends JpaRepository<Para,Integer> {
    List<Para> findBystNum(int n);
}
