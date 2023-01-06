package com.prueba.pattern.builder;

import com.prueba.entity.Cliente;

public class ClienteBuilder {
    private PersonaBuilder personaBuilder;
    private Long clienteId;
    private String contrasena;
    private String estado;

    public ClienteBuilder() {
    }

    public ClienteBuilder withPersonaBuilder(PersonaBuilder personaBuilder) {
        this.personaBuilder = personaBuilder;
        return this;
    }

    public ClienteBuilder withClienteId(Long clienteId) {
        this.clienteId = clienteId;
        return this;
    }

    public ClienteBuilder withContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public ClienteBuilder withEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public PersonaBuilder getPersonaBuilder() {
        return personaBuilder;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public Cliente build(){
        return new Cliente(this);
    }
}
