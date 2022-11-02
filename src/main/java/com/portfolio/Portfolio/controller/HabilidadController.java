package com.portfolio.Portfolio.controller;

import com.portfolio.Portfolio.model.Habilidad;
import com.portfolio.Portfolio.service.IHabilidadService;
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

@RestController
public class HabilidadController {
    @Autowired
    private IHabilidadService habilidadService;

    @CrossOrigin(origins = "https://portfolio-38aa5.web.app")  
    @GetMapping("/habilidad/get")
    public List<Habilidad> getHabilidad(){
        return habilidadService.getHabilidad();
    }
    
    @PostMapping("/habilidad/crear")
    public String createHabilidad(@RequestBody Habilidad habilidad){
        habilidadService.saveHabilidad(habilidad);
        return "Habilidad fue creada correctamente";
    }
    
    @DeleteMapping("/habilidad/borrar/{id}")
    public String deleteHabilidad(@PathVariable Long id){
        habilidadService.deleteHabilidad(id);
        return "Habilidad ha sido borrada exitosamente";
    }
    
    @PutMapping("/habilidad/editar/{id}")
    public Habilidad editHabilidad (@PathVariable Long id, 
                                @RequestParam ("cantidad") int nuevaCantidad,
                                @RequestParam ("color") String nuevoColor,
                                @RequestParam ("titulo") String nuevoTitulo)
                                {
    Habilidad habilidad = habilidadService.findHabilidad(id);
    habilidad.setCantidad(nuevaCantidad);
    habilidad.setColor(nuevoColor);
    habilidad.setTitulo(nuevoTitulo);
    
    habilidadService.saveHabilidad(habilidad);
    return habilidad;
}
    
}