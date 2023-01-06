package com.prueba.service;

import com.prueba.entity.Cuenta;
import com.prueba.response.CuentaResponse;

import java.util.List;

public interface CuentaService {
    List<CuentaResponse> obtenerTodasCuentas();

    List<CuentaResponse> obtenerCuentasPorUsuario(Long identificacion);

    String insertarCuenta(Cuenta cuenta);
    void actualizarCuenta(Cuenta cuenta, Long numeroCuenta);
    void eliminarCuenta(Long cuentaId);

}
