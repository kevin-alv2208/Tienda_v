package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "carrito_detalle")
public class CarritoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;
    private Long idCarrito;
    private double precio;
    private int cantidad;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne
    private Articulo articulo;

    public CarritoDetalle() {
    }

    public CarritoDetalle(Long idCarrito, double precio, int cantidad, Articulo articulo) {
        this.idCarrito = idCarrito;
        this.precio = precio;
        this.cantidad = cantidad;
        this.articulo = articulo;
    }
}
