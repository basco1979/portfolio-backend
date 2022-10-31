package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.Habilidad;
import com.portfolio.Portfolio.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HabilidadService implements IHabilidadService{
    @Autowired
    public HabilidadRepository habilidadRepository;

    @Override
    public List<Habilidad> getHabilidad() {
      List<Habilidad> listaHabilidad = habilidadRepository.findAll();
        return listaHabilidad;   
    }

    @Override
    public void saveHabilidad(Habilidad habilidad) {
        habilidadRepository.save(habilidad);
    }

    @Override
    public void deleteHabilidad(Long id) {
      habilidadRepository.deleteById(id);
    }

    @Override
    public Habilidad findHabilidad(Long id) {
    Habilidad habilidad = habilidadRepository.findById(id).orElse(null);
    return habilidad;
    }
    
}
