package com.jmingecor.jmingecor.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jmingecor.jmingecor.model.entity.ServicioCotizacion;

public interface IServicioCotizacionDAO  extends CrudRepository<ServicioCotizacion,Long>{
    @Query(value = "Select * from servicio_cotizacion s where s.id_cotizacion = ?1", nativeQuery = true)
    public List<ServicioCotizacion> cargarServCotizacion(Long idCot);
}
