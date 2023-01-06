package com.prueba.pattern.builder;

import com.prueba.entity.Cuenta;
import com.prueba.entity.Persona;
import jakarta.persistence.Column;

public class CuentaBuilder {
    private Long numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private String estado;
    private Long identificacion;

    public CuentaBuilder() {
    }

    public CuentaBuilder withNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        return this;
    }

    public CuentaBuilder withTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
        return this;
    }

    public CuentaBuilder withSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
        return this;
    }

    public CuentaBuilder withEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public CuentaBuilder withIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public String getEstado() {
        return estado;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public Cuenta build(){
        return new Cuenta(this);
    }
}
