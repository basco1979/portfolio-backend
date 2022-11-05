package com.portfolio.Portfolio.service;
import com.portfolio.Portfolio.model.Imagen;
import java.util.List;

public interface IImagenService {
    public List<Imagen> getImagen();
    public void saveImagen(Imagen imagen);
    public void deleteImagen(Long id);
    public Imagen findImagen(Long id);
}
