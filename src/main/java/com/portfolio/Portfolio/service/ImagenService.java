package com.portfolio.Portfolio.service;
import com.portfolio.Portfolio.model.Imagen;
import com.portfolio.Portfolio.repository.ImagenRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenService implements IImagenService {


    @Autowired
    public ImagenRepository imagenRepository;

    @Override
    public List<Imagen> getImagen() {
      List<Imagen> listaImagen = imagenRepository.findAll();
        return listaImagen;   
    }

    @Override
    public void saveImagen(Imagen imagen) {
        imagenRepository.save(imagen);
    }

    @Override
    public void deleteImagen(Long id) {
      imagenRepository.deleteById(id);
    }

    @Override
    public Imagen findImagen(Long id) {
    Imagen imagen = imagenRepository.findById(id).orElse(null);
    return imagen;
    }
    
}
