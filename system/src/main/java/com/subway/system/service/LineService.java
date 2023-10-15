package com.subway.system.service;

import java.util.List;

import com.subway.system.model.Line;

public interface LineService {
    public Line saveLine(Line line);
    public List<Line> getAllLines();
}
