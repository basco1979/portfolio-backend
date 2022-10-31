package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.AcercaDe;
import com.portfolio.Portfolio.repository.AcercaDeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AcercaDeService implements IAcercaDeService{
    @Autowired
    public AcercaDeRepository acercadeRepository;

    @Override
    public List<AcercaDe> getAcercaDe() {
      List<AcercaDe> listaAcercaDe = acercadeRepository.findAll();
        return listaAcercaDe;   
    }

    @Override
    public void saveAcercaDe(AcercaDe acercade) {
        acercadeRepository.save(acercade);
    }

    @Override
    public void deleteAcercaDe(Long id) {
      acercadeRepository.deleteById(id);
    }

    @Override
    public AcercaDe findAcercaDe(Long id) {
    AcercaDe acercade = acercadeRepository.findById(id).orElse(null);
    return acercade;
    }
    
}
