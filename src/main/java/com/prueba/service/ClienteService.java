package com.prueba.service;

import com.prueba.entity.Cliente;
import com.prueba.response.ClienteResponse;

import java.util.List;

public interface ClienteService {
    List<ClienteResponse> obtenerTodosClientes();
    String insertarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente, Long clientId);
    void eliminarCliente(Long clienteId);


}
