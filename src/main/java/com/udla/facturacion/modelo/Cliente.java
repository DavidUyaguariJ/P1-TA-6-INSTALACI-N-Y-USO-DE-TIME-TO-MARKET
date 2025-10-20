package com.udla.facturacion.modelo;

import javax.persistence.*;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Data
@View(name = "Simple", members = "numero, nombre")
public class Cliente {
	@Id
	@Column(length=6)
	int numero;
	
	@Column(length=50)
	@Required
	String nombre;
	
	@Embedded
	Direccion direccion;
}
