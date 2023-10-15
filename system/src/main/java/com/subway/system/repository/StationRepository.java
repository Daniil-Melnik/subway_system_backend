package com.subway.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subway.system.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station,Integer> {
}
