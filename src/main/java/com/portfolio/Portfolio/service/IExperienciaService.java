package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.Experiencia;
import java.util.List;

public interface IExperienciaService {

    public List<Experiencia> getExperiencia();
    public void saveExperiencia(Experiencia experiencia);
    public void deleteExperiencia(Long id);
    public Experiencia findExperiencia(Long id);
}