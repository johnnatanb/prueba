package com.prueba.service;

import com.prueba.entity.Movimientos;
import com.prueba.response.MovimientosResponse;

import java.text.ParseException;
import java.util.List;

public interface MovimientosService {
    List<MovimientosResponse> obtenerTodosMovimientos(Long identificacion, String desde, String hasta) throws ParseException;
    String insertarMovimiento(Movimientos movimientos) throws ParseException;

}
