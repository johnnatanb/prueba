package com.prueba.controller;

import com.prueba.entity.Movimientos;
import com.prueba.response.ClienteResponse;
import com.prueba.response.MovimientosResponse;
import com.prueba.service.MovimientosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovimientosController {
    private static final Logger logger = LoggerFactory.getLogger(MovimientosController.class);
    @Autowired
    MovimientosService movimientosService;

    @RequestMapping(value = "/movimientos/{identificacion}", method = RequestMethod.GET)
    public ResponseEntity<List<MovimientosResponse>>  getMovimientos(@PathVariable("identificacion") Long identificacion, @RequestParam(value = "desde") String desde, @RequestParam(value = "hasta") String hasta) throws ParseException {
        try {
            logger.info("Inicio obtener movimientos por cliente por rango de fecha");
            return new ResponseEntity<List<MovimientosResponse>>(movimientosService.obtenerTodosMovimientos(identificacion, desde, hasta), HttpStatus.OK);
        }catch (Exception e) {
            List<MovimientosResponse> response = new ArrayList<>();
            logger.info("Se presento un error al obtener movimientos por cliente por rango de fecha");
            return new ResponseEntity<List<MovimientosResponse>>(response, HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

    @RequestMapping(value = "/movimientos", method = RequestMethod.POST)
    public ResponseEntity<String> insertarMovimiento(@RequestBody Movimientos movimientos) throws ParseException {
        try {
            logger.info("Inicio insertar movimiento");
            String response = movimientosService.insertarMovimiento(movimientos);
            logger.info("Movimiento insertado con éxito");
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }catch (Exception e) {
            logger.info("Se presento un error al insertar el movimiento");
            return new ResponseEntity<String>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
