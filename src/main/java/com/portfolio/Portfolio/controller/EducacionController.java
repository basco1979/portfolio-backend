package com.portfolio.Portfolio.controller;

import com.portfolio.Portfolio.model.Educacion;
import com.portfolio.Portfolio.service.IEducacionService;
import com.portfolio.Portfolio.service.ServiceFile;
import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EducacionController {
    @Autowired
    private IEducacionService educacionService;
    @Autowired
    ServiceFile serviceFile;
    
        @CrossOrigin(origins = "https://portfolio-38aa5.web.app")
    @GetMapping("/educacion/get")
    public List<Educacion> getEducacion(){
        return educacionService.getEducacion();
    }
   
    
         @CrossOrigin(origins = "https://portfolio-38aa5.web.app")
    @PostMapping("/educacion/crear")
    public String createEducacion(@RequestBody Educacion educacion){
        educacionService.saveEducacion(educacion);
        return "Educacion fue creada correctamente";
    }
         @CrossOrigin(origins = "https://portfolio-38aa5.web.app")
    @DeleteMapping("/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id){
        educacionService.deleteEducacion(id);
        return "Educacion ha sido borrada exitosamente";
    }
         @CrossOrigin(origins = "https://portfolio-38aa5.web.app")
    @PutMapping("/educacion/editar/{id}")
    public Educacion editEducacion (@PathVariable Long id, 
                                @RequestParam ("img") String nuevaImg,
                                @RequestParam ("institucion") String nuevaInstitucion,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("fecha_inicio") String nuevaFechaInicio,
                                @RequestParam ("fecha_fin") String nuevaFechaFin)
                                {
    Educacion educacion = educacionService.findEducacion(id);
    educacion.setImg(nuevaImg);
    educacion.setInstitucion(nuevaInstitucion);
    educacion.setTitulo(nuevoTitulo);
    educacion.setFecha_inicio(nuevaFechaInicio);
    educacion.setFecha_fin(nuevaFechaFin);
    
    educacionService.saveEducacion(educacion);
    return educacion;
}
    
}