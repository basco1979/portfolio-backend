package com.portfolio.Portfolio.controller;

import com.portfolio.Portfolio.model.Perfil;
import com.portfolio.Portfolio.service.IPerfilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "https://portfolio-38aa5.web.app")
@RestController
public class PerfilController {
    @Autowired
    private IPerfilService perfilService;
    
    @GetMapping("/perfil/get")
    public List<Perfil> getPerfil(){
        return perfilService.getPerfil();
    }
    
    @PostMapping("/perfil/crear")
    public String createPerfil(@RequestBody Perfil perfil){
        perfilService.savePerfil(perfil);
        return "Perfil fue creado correctamente";
    }
    
    @DeleteMapping("/perfil/borrar/{id}")
    public String deletePerfil(@PathVariable Long id){
        perfilService.deletePerfil(id);
        return "Perfil ha sido borrado exitosamente";
    }
    
    @PutMapping("/perfil/editarFotoPerfil/{id}")
    public Perfil editFotoPerfil (@PathVariable Long id, 
                                @RequestParam ("imgPerfil") String nuevaImgPerfil)
                                {
    Perfil perfil = perfilService.findPerfil(id);
    perfil.setImgPerfil(nuevaImgPerfil);
    perfilService.savePerfil(perfil);
    return perfil;
}

    @PutMapping("/perfil/editarBanner/{id}")
    public Perfil editBanner (@PathVariable Long id, 
                                @RequestParam ("imgBanner") String nuevaImgBanner)
                                {
    Perfil perfil = perfilService.findPerfil(id);
    perfil.setImgBanner(nuevaImgBanner);
    perfilService.savePerfil(perfil);
    return perfil;
}

    @PutMapping("/perfil/editarTexto/{id}")
    public Perfil editTexto (@PathVariable Long id, 
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("descripcion") String nuevaDescripcion)
                                {
    Perfil perfil = perfilService.findPerfil(id);
    perfil.setNombre(nuevoNombre);
    perfil.setDescripcion(nuevaDescripcion);
    perfilService.savePerfil(perfil);
    return perfil;
}
    
}