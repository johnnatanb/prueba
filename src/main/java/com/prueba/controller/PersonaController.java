//package com.prueba.controller;
//
//import com.prueba.entity.Persona;
//import com.prueba.service.PersonaService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class PersonaController {
//    @Autowired
//    PersonaService personaService;
//
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String getHello() {
//        return "Hello World!!!!!";
//    }
//    @RequestMapping(value = "/personas", method = RequestMethod.GET)
//    public List<Persona> getPersonas() {
//        return personaService.getAllPersonas();
//    }
//
//    @RequestMapping(value = "/insertpersona", method = RequestMethod.POST)
//    public void insertEmployee(@RequestBody Persona persona) {
//        personaService.insertPersona(persona);
//    }
//}
