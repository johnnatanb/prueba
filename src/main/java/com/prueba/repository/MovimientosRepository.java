package com.prueba.repository;

import com.prueba.entity.Movimientos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface MovimientosRepository extends CrudRepository<Movimientos, Long> {
    @Query("select m from Movimientos m where m.numeroCuenta = ?1 order by id DESC LIMIT 1")
    List<Movimientos> findUltimoMovimientoPorNumeroCuenta(Long numeroCuenta);
    @Query("select Distinct m from Movimientos m where m.numeroCuenta in ?1 AND m.fecha BETWEEN ?2 AND ?3")
    List<Movimientos> findReporteCuentasUsuarioFechas(Collection<Long> numeroCuentas, LocalDateTime fecha, LocalDateTime fecha1);
}
