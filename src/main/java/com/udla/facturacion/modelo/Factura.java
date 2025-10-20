package com.udla.facturacion.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.udla.facturacion.calculadores.*;

import lombok.*;

@Entity
@Data
@View(members= "anio, numero, fecha;"+"cliente;"+"detalles;"+"observaciones"
)
public class Factura {
	
	@Id
	@Hidden
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(length=32)
	String id;

	@DefaultValueCalculator(CurrentYearCalculator.class)
	int anio;
	
	@Column(length=6)
	@DefaultValueCalculator(value=CalculadorSiguienteNumero.class, 
	properties =@PropertyValue(name= "anio"))
	int numero;
	
	@Required
	@DefaultValueCalculator(CurrentLocalDateCalculator.class)
	LocalDate fecha;
	
	@ManyToOne
	(fetch=FetchType.LAZY,
	optional=true)
	@ReferenceView("Simple")
	Cliente cliente;
	
	@ElementCollection
	@ListProperties("producto.numero, producto.descripcion, cantidad")
	Collection<Detalle> detalles;
	
	@Stereotype("MEMO")
	String observaciones;
	
}
