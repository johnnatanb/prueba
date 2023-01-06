package com.prueba.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDateTime fecha;
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    private Double valor;
    private Double saldo;
    @Column(name = "numero_cuenta")
    private Long numeroCuenta;

    public Movimientos() {
    }

    public Movimientos(LocalDateTime fecha, String tipoMovimiento, Double valor, Double saldo, Long numeroCuenta) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

//    public Integer getId() {
//        return id;
//    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
