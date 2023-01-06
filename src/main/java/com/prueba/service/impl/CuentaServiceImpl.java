package com.prueba.service.impl;

import com.prueba.entity.Cliente;
import com.prueba.entity.Cuenta;
import com.prueba.repository.ClienteRepository;
import com.prueba.repository.CuentaRepository;
import com.prueba.response.CuentaResponse;
import com.prueba.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<CuentaResponse> obtenerTodasCuentas() {
        List<CuentaResponse> cuentaResponses = new ArrayList<>();
        cuentaRepository.findAll().forEach(cuenta -> {
            CuentaResponse cuentaResponse = new CuentaResponse();
            cuentaResponse.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaResponse.setTipo(cuenta.getTipoCuenta());
            cuentaResponse.setSaldoInicial(cuenta.getSaldoInicial());
            cuentaResponse.setEstado(cuenta.getEstado());
            Cliente cliente = clienteRepository.findById(cuenta.getIdentificacion()).get();
            cuentaResponse.setCliente(cliente.getNombre());
            cuentaResponses.add(cuentaResponse);
        });
        return cuentaResponses;
    }

    @Override
    public List<CuentaResponse> obtenerCuentasPorUsuario(Long identificacion) {
        List<CuentaResponse> cuentaResponses = new ArrayList<>();
        cuentaRepository.findAllByUser(identificacion).forEach(cuenta -> {
            CuentaResponse cuentaResponse = new CuentaResponse();
            cuentaResponse.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaResponse.setTipo(cuenta.getTipoCuenta());
            cuentaResponse.setSaldoInicial(cuenta.getSaldoInicial());
            cuentaResponse.setEstado(cuenta.getEstado());
            Cliente cliente = clienteRepository.findById(cuenta.getIdentificacion()).get();
            cuentaResponse.setCliente(cliente.getNombre());
            cuentaResponses.add(cuentaResponse);
        });
        return cuentaResponses;
    }

    @Override
    public String insertarCuenta(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
        return "Cuenta insertada correctamente: " + cuenta.getNumeroCuenta();
    }

    @Override
    public void actualizarCuenta(Cuenta cuenta, Long cuentaId) {
        if(Objects.nonNull(cuenta) && (Objects.isNull(cuenta.getNumeroCuenta()) || cuenta.getNumeroCuenta().equals(cuentaId))){
            Cuenta c = cuentaRepository.findById(cuentaId).get();
            if(Objects.nonNull(c)){
                cuenta.setNumeroCuenta(cuentaId);
                cuentaRepository.save(cuenta);
            }
        }

    }

    @Override
    public void eliminarCuenta(Long cuentaId) {
        cuentaRepository.deleteById(cuentaId);

    }
}
