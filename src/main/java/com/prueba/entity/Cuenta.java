package com.prueba.entity;


import com.prueba.pattern.builder.CuentaBuilder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "numero_cuenta")
    private Long numeroCuenta;
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Column(name = "saldo_inicial")
    private Double saldoInicial;
    private String estado;
    @Column(name = "identificacion")
    private Long identificacion;

    public Cuenta() {
    }

    public Cuenta(CuentaBuilder cuentaBuilder) {
        this.numeroCuenta = cuentaBuilder.getNumeroCuenta();
        this.tipoCuenta = cuentaBuilder.getTipoCuenta();
        this.saldoInicial = cuentaBuilder.getSaldoInicial();
        this.estado = cuentaBuilder.getEstado();
        this.identificacion = cuentaBuilder.getIdentificacion();
    }

    public Cuenta(Long numeroCuenta, String tipoCuenta, Double saldoInicial, String estado, Long clienteId) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.identificacion = clienteId;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }
}
