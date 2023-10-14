package com.subway.system.service;

import java.util.List;

import com.subway.system.model.Para;

public interface ParaService {
    public Para savePara(Para para);
    public List<Para> getAllParas();
}