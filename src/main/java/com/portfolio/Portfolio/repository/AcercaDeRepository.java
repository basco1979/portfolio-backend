package com.portfolio.Portfolio.repository;

import com.portfolio.Portfolio.model.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface AcercaDeRepository extends JpaRepository <AcercaDe, Long> {
     
}
