package com.portfolio.Portfolio.repository;
import com.portfolio.Portfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ProyectoRepository extends JpaRepository <Proyecto, Long> {
     
}