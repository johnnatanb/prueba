package com.prueba.entity;


import com.prueba.pattern.builder.ClienteBuilder;
import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "identificacion")
@Table(name = "cliente")
public class Cliente extends Persona{
//    @Id
    private Long identificacion;
    private String contrasena;
    private String estado;
    public Cliente() {
        super();
    }

    public Cliente(Long identificacion, String contrasena, String estado) {
        this.identificacion = identificacion;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public Cliente(ClienteBuilder clienteBuilder) {
        super(clienteBuilder.getPersonaBuilder());
        this.identificacion = clienteBuilder.getClienteId();
        this.contrasena = clienteBuilder.getContrasena();
        this.estado = clienteBuilder.getEstado();
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
