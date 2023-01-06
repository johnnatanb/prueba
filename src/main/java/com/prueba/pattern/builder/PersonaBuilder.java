package com.prueba.pattern.builder;

import com.prueba.entity.Persona;

public class PersonaBuilder {
    private Long identificacion;
    private String nombre;
    private String genero;
    private String edad;
    private String direccion;
    private String telefono;

    public PersonaBuilder() {
    }

    public PersonaBuilder withIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
        return this;

    }

    public PersonaBuilder withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PersonaBuilder withGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public PersonaBuilder withEdad(String edad) {
        this.edad = edad;
        return this;
    }

    public PersonaBuilder withDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public PersonaBuilder withTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public Persona build(){
        return new Persona(this);
    }
}
