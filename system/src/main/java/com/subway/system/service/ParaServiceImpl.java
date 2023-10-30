package com.subway.system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subway.system.model.Para;
import com.subway.system.repository.ParaRepository;

import java.util.List;

@Service
public class ParaServiceImpl implements ParaService {

    @Autowired
    private ParaRepository paraRepository;

    @Override
    public Para savePara(Para para) {
        return paraRepository.save(para);
    }

    @Override
    public List<Para> getAllParas() {
        return paraRepository.findAll();
    }

    @Override
    public List<Para> getParasByStID(int id) {
        return paraRepository.findBystNum(id);
    }
}

