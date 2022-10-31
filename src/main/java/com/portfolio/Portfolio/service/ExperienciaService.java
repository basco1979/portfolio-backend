package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.Experiencia;
import com.portfolio.Portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ExperienciaService implements IExperienciaService{
    @Autowired
    public ExperienciaRepository experienciaRepository;

    @Override
    public List<Experiencia> getExperiencia() {
      List<Experiencia> listaExperiencia = experienciaRepository.findAll();
        return listaExperiencia;   
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
      experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
    Experiencia experiencia = experienciaRepository.findById(id).orElse(null);
    return experiencia;
    }
    
}
