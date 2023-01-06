package com.prueba.service.impl;

import com.prueba.entity.Cliente;
import com.prueba.entity.Cuenta;
import com.prueba.entity.Movimientos;
import com.prueba.entity.TipoMovimiento;
import com.prueba.repository.ClienteRepository;
import com.prueba.repository.CuentaRepository;
import com.prueba.repository.MovimientosRepository;
import com.prueba.response.MovimientosResponse;
import com.prueba.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovimientoServiceImpl implements MovimientosService {
    @Autowired
    MovimientosRepository movimientosRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    public List<MovimientosResponse> obtenerTodosMovimientos(Long identificacion, String desde, String hasta) throws ParseException {
        List<MovimientosResponse> movimientosResponses = new ArrayList<>();
        Cliente cliente = clienteRepository.findById(identificacion).get();
        if(Objects.nonNull(cliente)){
            List<Cuenta> cuentas = cuentaRepository.findAllByUser(identificacion);
            Collection<Long> numerosCuentas = cuentas.stream().map(Cuenta::getNumeroCuenta).collect(Collectors.toList());
            if(Objects.nonNull(cuentas) && cuentas.size()>0){
                DateTimeFormatter formatter
                        = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

                SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
                LocalDateTime desdee = LocalDateTime.parse(desde+"T00:00:00.00");
                LocalDateTime hastaa = LocalDateTime.parse(hasta+"T23:59:59.00");
                movimientosRepository.findReporteCuentasUsuarioFechas(numerosCuentas, desdee, hastaa).forEach(movimientos -> {
                    Cuenta cuentaIteracion = cuentas.stream().filter(cuenta -> cuenta.getNumeroCuenta().equals(movimientos.getNumeroCuenta())).findFirst().get();
                    MovimientosResponse movimientosResponse = new MovimientosResponse();
                    movimientosResponse.setFecha(movimientos.getFecha());
                    movimientosResponse.setCliente(cliente.getNombre());
                    movimientosResponse.setNumeroCuenta(movimientos.getNumeroCuenta());
                    movimientosResponse.setTipo(cuentaIteracion.getTipoCuenta());
                    movimientosResponse.setSaldoInicial(cuentaIteracion.getSaldoInicial());
                    movimientosResponse.setEstado(cuentaIteracion.getEstado());
                    movimientosResponse.setMovimiento(movimientos.getValor());
                    movimientosResponse.setSaldoDisponible(movimientos.getSaldo());
                    movimientosResponses.add(movimientosResponse);
                });
            }
        }
        return movimientosResponses;
    }

    @Override
    public String insertarMovimiento(Movimientos movimientos) throws ParseException {
        Cuenta cuenta = cuentaRepository.findById(movimientos.getNumeroCuenta()).get();
        Boolean permiteMovimiento = false;
        Double nuevoSaldo;
        if(Objects.nonNull(cuenta)){
            List<Movimientos> ultimo = movimientosRepository.findUltimoMovimientoPorNumeroCuenta(cuenta.getNumeroCuenta());
            if(Objects.nonNull(ultimo) && ultimo.size()>0){
                nuevoSaldo = ultimo.get(0).getSaldo() + movimientos.getValor();
            } else {
                nuevoSaldo = cuenta.getSaldoInicial() + movimientos.getValor();
            }
            if(movimientos.getTipoMovimiento().equals(TipoMovimiento.RETIRO)) {
                permiteMovimiento = nuevoSaldo >= 0;
                if(!permiteMovimiento) {
                    return "Saldo no disponible";
                }
            }
            movimientos.setSaldo(nuevoSaldo);
            LocalDateTime date = LocalDateTime.now();
            movimientos.setFecha(date);
            movimientosRepository.save(movimientos);

        }
        return "Movimiento insertado correctamente: " + movimientos.getNumeroCuenta();
    }
}
