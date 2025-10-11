package com.udla.facturacion.modelo;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Data
public class Direccion {
	
	@Column(length=30)
	String viaPublica;
	
	@Column(length=5)
	int codigoPostal;

	@Column(length=20)
	String municipio;
	
	@Column(length=30)
	String provincia;
}
