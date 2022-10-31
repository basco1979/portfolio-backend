/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.Portfolio.security.controller;


import com.portfolio.Portfolio.security.dto.JwtDto;
import com.portfolio.Portfolio.security.dto.LoginUsuario;
import com.portfolio.Portfolio.security.dto.Mensaje;
import com.portfolio.Portfolio.security.dto.NuevoUsuario;
import com.portfolio.Portfolio.security.entity.Rol;
import com.portfolio.Portfolio.security.entity.Usuario;
import com.portfolio.Portfolio.security.enums.RolNombre;
import com.portfolio.Portfolio.security.jwt.JwtProvider;
import com.portfolio.Portfolio.security.service.RolService;
import com.portfolio.Portfolio.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    //Espera un json y lo convierte a tipo clase NuevoUsuario
    @PostMapping("/nuevoUsuario")
    public ResponseEntity<?> nuevoUsuario(@RequestBody NuevoUsuario nuevoUsuario,
                                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new Mensaje("Campos mal o email invalido"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity<>(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity<>(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);

        usuarioService.save(usuario);

        return new ResponseEntity<>(new Mensaje("Usuario creado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(),
                                loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
}