package com.prueba.entity;


import com.prueba.pattern.builder.PersonaBuilder;
import jakarta.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificacion;
    private String nombre;
    private String genero;
    private String edad;
    private String direccion;
    private String telefono;

    public Persona() {
    }

    public Persona(Long identificacion, String nombre, String genero, String edad, String direccion, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Persona(PersonaBuilder personaBuilder) {
        this.identificacion = personaBuilder.getIdentificacion();
        this.nombre = personaBuilder.getNombre();
        this.genero = personaBuilder.getGenero();
        this.edad = personaBuilder.getEdad();
        this.direccion = personaBuilder.getDireccion();
        this.telefono = personaBuilder.getTelefono();

    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
