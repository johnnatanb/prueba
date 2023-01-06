package com.prueba.repository;

import com.prueba.entity.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long> {
//    @Query("select c.numero_cuenta from Cuenta c where c.identificacion = ?1")
//    List<Long> findAllNumeroCuentaByUser(Long identificacion);

    @Query("select c from Cuenta c where c.identificacion = ?1")
    List<Cuenta> findAllByUser(Long identificacion);

}
