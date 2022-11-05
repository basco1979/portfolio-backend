
package com.portfolio.Portfolio.controller;
import com.portfolio.Portfolio.model.Imagen;
import com.portfolio.Portfolio.repository.ImagenRepository;
import com.portfolio.Portfolio.util.ImageUtility;
import com.portfolio.Portfolio.service.IImagenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Optional;
@CrossOrigin(origins = "https://portfolio-38aa5.web.app")
@RestController
public class ImagenController {
    @Autowired
    private IImagenService imagenService;
        @Autowired
    ImagenRepository imageRepository;

    @GetMapping("/imagen/get")
    public List<Imagen> getImagen(){
        return imagenService.getImagen();
    }
@CrossOrigin(origins = "https://portfolio-38aa5.web.app")    
    @PostMapping("/imagen/crear")
  public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file)
            throws IOException {

        imageRepository.save(Imagen.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }
    
    @PutMapping("/imagen/editar/{id}")
    public Imagen editImagen (@PathVariable Long id, 
                                @RequestParam ("descripcion") String nuevaDescripcion)
                                {
    Imagen imagen = imagenService.findImagen(id);
    imagen.setName(nuevaDescripcion);
    
    imagenService.saveImagen(imagen);
    return imagen;
}
    
}