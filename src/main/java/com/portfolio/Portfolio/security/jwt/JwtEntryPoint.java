/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.Portfolio.security.jwt;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Comprueba si existe un token si no devuelve un 401 no autorizado
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    // Implementamos un logger para ver cual metodo da error en caso de falla
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

  //Metodo implementado de AuthenticationEntryPoint
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        logger.error("Fallo el metodo  : {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No esta autorizado");
    }
}