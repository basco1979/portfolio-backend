/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.portfolio.Portfolio.repository;

import com.portfolio.Portfolio.model.Imagen;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface ImagenRepository extends JpaRepository <Imagen, Long> {
     Optional<Imagen> findByName(String name);
}