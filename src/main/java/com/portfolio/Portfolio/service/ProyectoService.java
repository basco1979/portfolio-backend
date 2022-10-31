package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    public ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> getProyecto() {
      List<Proyecto> listaProyecto = proyectoRepository.findAll();
        return listaProyecto;   
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
      proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
    Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
    return proyecto;
    }
    
}
