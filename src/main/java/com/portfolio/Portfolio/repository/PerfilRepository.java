package com.portfolio.Portfolio.repository;
import com.portfolio.Portfolio.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface PerfilRepository extends JpaRepository <Perfil, Long> {
     
}
   
