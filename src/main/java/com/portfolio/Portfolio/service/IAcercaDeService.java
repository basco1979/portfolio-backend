package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.AcercaDe;
import java.util.List;

public interface IAcercaDeService {

    public List<AcercaDe> getAcercaDe();
    public void saveAcercaDe(AcercaDe acercade);
    public void deleteAcercaDe(Long id);
    public AcercaDe findAcercaDe(Long id);
}