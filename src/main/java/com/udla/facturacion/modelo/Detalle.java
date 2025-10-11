package com.udla.facturacion.modelo;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Data
public class Detalle {
	
	int cantidad;
	
	@ManyToOne
	(fetch=FetchType.LAZY,
	optional=true)
	Producto producto;

}
