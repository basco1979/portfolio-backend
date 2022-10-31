package com.portfolio.Portfolio.service;

import com.portfolio.Portfolio.model.Perfil;
import java.util.List;

public interface IPerfilService {

    public List<Perfil> getPerfil();
    public void savePerfil(Perfil perfil);
    public void deletePerfil(Long id);
    public Perfil findPerfil(Long id);
}