package com.subway.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subway.system.model.Station;
import com.subway.system.repository.StationRepository;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;

    @Override
    public Station saveStation(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }
}