package com.prueba.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.entity.Cuenta;
import com.prueba.pattern.builder.CuentaBuilder;
import com.prueba.service.CuentaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.*;
@SpringBootTest
@AutoConfigureMockMvc
public class CuentaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CuentaService cuentaService;

    @Test
    @DisplayName(value = "POST insertar /cuentas BadRequest")
    public void testInsertarCuentaBadRequest() {
        try {
            mockMvc.perform(post("/cuentas")
                            .accept("application/json;charset=UTF-8"))

                    // Validate the response code and content type
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName(value = "POST insertar /cuentas Success")
    public void testInsertarCuentasSuccess() {
        Cuenta cuenta = new CuentaBuilder()
                .withNumeroCuenta(10L)
                .withTipoCuenta("Ahorros")
                .withSaldoInicial(2000D)
                .withEstado("True")
                .withIdentificacion(10L).build();

        doReturn("Cuenta insertada correctamente: " + cuenta.getNumeroCuenta()).when(cuentaService).insertarCuenta(cuenta);

        try {
            mockMvc.perform(post("/cuentas")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(cuenta)))

                    // Validate the response code and content type
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.TEXT_PLAIN+";charset=UTF-8"))

                    // Validate the returned fields
                    .andExpect(content().string(containsString("Cuenta insertada correctamente")));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
