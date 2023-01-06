package com.prueba.service.impl;

import com.prueba.entity.Persona;
import com.prueba.repository.PersonaRepository;
import com.prueba.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public List<Persona> getAllPersonas() {
        List<Persona> personas = StreamSupport.stream(personaRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return personas;
    }

    @Override
    public void insertPersona(Persona persona) {
        personaRepository.save(persona);
    }
}
