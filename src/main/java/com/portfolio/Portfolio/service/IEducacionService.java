package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {

    public List<Educacion> getEducacion();
    public void saveEducacion(Educacion educacion);
    public void deleteEducacion(Long id);
    public Educacion findEducacion(Long id);
}