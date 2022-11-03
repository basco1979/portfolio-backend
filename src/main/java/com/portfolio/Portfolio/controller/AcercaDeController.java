package com.portfolio.Portfolio.controller;

import com.portfolio.Portfolio.model.AcercaDe;
import com.portfolio.Portfolio.service.IAcercaDeService;
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
public class AcercaDeController {
    @Autowired
    private IAcercaDeService acercaDeService;
    
    @CrossOrigin(origins = "https://portfolio-38aa5.web.app")
    @GetMapping("/acercade/get")
    public List<AcercaDe> getAcercaDe(){
        return acercaDeService.getAcercaDe();
    }
    
    @PostMapping("/acercade/crear")
    public String createAcercaDe(@RequestBody AcercaDe acercaDe){
        acercaDeService.saveAcercaDe(acercaDe);
        return "AcercaDe fue creada correctamente";
    }
    
    @DeleteMapping("/acercade/borrar/{id}")
    public String deleteAcercaDe(@PathVariable Long id){
        acercaDeService.deleteAcercaDe(id);
        return "AcercaDe ha sido borrada exitosamente";
    }
    @CrossOrigin(origins = "https://portfolio-38aa5.web.app")    
    @PutMapping("/acercaDe/editar/{id}")
    public AcercaDe editAcercaDe (@PathVariable Long id, 
                                @RequestParam ("descripcion") String nuevaDescripcion)
                                {
    AcercaDe acercade = acercaDeService.findAcercaDe(id);
    acercade.setDescripcion(nuevaDescripcion);
    
    acercaDeService.saveAcercaDe(acercade);
    return acercade;
}
    
}