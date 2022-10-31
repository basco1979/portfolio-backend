package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.Perfil;
import com.portfolio.Portfolio.repository.PerfilRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PerfilService implements IPerfilService{
    @Autowired
    public PerfilRepository perfilRepository;

    @Override
    public List<Perfil> getPerfil() {
      List<Perfil> listaPerfil = perfilRepository.findAll();
        return listaPerfil;   
    }

    @Override
    public void savePerfil(Perfil perfil) {
        perfilRepository.save(perfil);
    }

    @Override
    public void deletePerfil(Long id) {
      perfilRepository.deleteById(id);
    }

    @Override
    public Perfil findPerfil(Long id) {
    Perfil perfil = perfilRepository.findById(id).orElse(null);
    return perfil;
    }
    
}
