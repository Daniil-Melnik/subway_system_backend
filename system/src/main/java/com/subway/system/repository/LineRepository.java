package com.subway.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subway.system.model.Line;

@Repository
public interface LineRepository extends JpaRepository<Line,Integer> {
}
