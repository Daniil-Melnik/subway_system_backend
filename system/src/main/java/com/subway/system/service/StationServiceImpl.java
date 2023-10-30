package com.subway.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subway.system.model.Station;
import com.subway.system.repository.StationRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Station> getStationByID(int id) {
        return stationRepository.findById(id);
    }
}