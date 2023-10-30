package com.subway.system.service;

import java.util.List;
import java.util.Optional;

import com.subway.system.model.Station;

public interface StationService {
    public Station saveStation(Station photo);
    public List<Station> getAllStations();
    public Optional<Station> getStationByID(int id);
}