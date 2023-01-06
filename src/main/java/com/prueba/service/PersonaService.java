package com.prueba.service;

import com.prueba.entity.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> getAllPersonas();
    void insertPersona(Persona persona);

}
