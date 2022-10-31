package com.portfolio.Portfolio.controller;

import com.portfolio.Portfolio.model.Experiencia;
import com.portfolio.Portfolio.service.IExperienciaService;
import java.time.LocalDate;
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
public class ExperienciaController {
    @Autowired
    private IExperienciaService experienciaService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/experiencia/get")
    public List<Experiencia> getExperiencia(){
        return experienciaService.getExperiencia();
    }
    
    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia){
        experienciaService.saveExperiencia(experiencia);
        return "Experiencia fue creada correctamente";
    }
    
    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        experienciaService.deleteExperiencia(id);
        return "Experiencia ha sido borrada exitosamente";
    }
    
    @PutMapping("/experiencia/editar/{id}")
    public Experiencia editExperiencia (@PathVariable Long id, 
                                @RequestParam ("img") String nuevaImg,
                                @RequestParam ("descripcion") String nuevaDescripcion,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("fecha_inicio") LocalDate nuevaFechaInicio,
                                @RequestParam ("fecha_fin") LocalDate nuevaFechaFin)
                                {
    Experiencia experiencia = experienciaService.findExperiencia(id);
    experiencia.setImg(nuevaImg);
    experiencia.setDescripcion(nuevaDescripcion);
    experiencia.setTitulo(nuevoTitulo);
    experiencia.setFecha_inicio(nuevaFechaInicio);
    experiencia.setFecha_fin(nuevaFechaFin);
    
    experienciaService.saveExperiencia(experiencia);
    return experiencia;
}
    
}