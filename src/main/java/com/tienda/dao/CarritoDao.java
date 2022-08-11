package com.tienda.dao;

import com.tienda.domain.Carrito;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CarritoDao extends CrudRepository<Carrito, Long> {

    Optional<Carrito> findByIdCliente(Long idCliente);
}
