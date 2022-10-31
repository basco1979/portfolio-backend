package com.portfolio.Portfolio.controller;

import com.portfolio.Portfolio.model.Proyecto;
import com.portfolio.Portfolio.service.IProyectoService;
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
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/proyecto/get")
    public List<Proyecto> getProyecto(){
        return proyectoService.getProyecto();
    }
    
    @PostMapping("/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto proyecto){
        proyectoService.saveProyecto(proyecto);
        return "Proyecto fue creado correctamente";
    }
    
    @DeleteMapping("/proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id){
        proyectoService.deleteProyecto(id);
        return "Proyecto ha sido borrado exitosamente";
    }
    
    @PutMapping("/proyecto/editar/{id}")
    public Proyecto editProyecto (@PathVariable Long id, 
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("link") String nuevoLink,
                                @RequestParam ("descripcion") String nuevaDescripcion)
                                {
    Proyecto proyecto = proyectoService.findProyecto(id);
    proyecto.setTitulo(nuevoTitulo);
    proyecto.setLink(nuevoLink);
    proyecto.setDescripcion(nuevaDescripcion);
    
    proyectoService.saveProyecto(proyecto);
    return proyecto;
}
    
}