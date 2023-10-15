package com.subway.system.service;

import java.util.List;

import com.subway.system.model.Station;

public interface StationService {
    public Station saveStation(Station photo);
    public List<Station> getAllStations();
}