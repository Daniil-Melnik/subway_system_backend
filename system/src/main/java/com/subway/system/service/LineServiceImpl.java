package com.subway.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subway.system.model.Line;
import com.subway.system.repository.LineRepository;

import java.util.List;

@Service
public class LineServiceImpl implements LineService {

    @Autowired
    private LineRepository lineRepository;

    @Override
    public Line saveLine(Line line) {
        return lineRepository.save(line);
    }

    @Override
    public List<Line> getAllLines() {
        return lineRepository.findAll();
    }
}