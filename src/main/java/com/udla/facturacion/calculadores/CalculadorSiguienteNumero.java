package com.udla.facturacion.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;

@RequiredArgsConstructor
public class CalculadorSiguienteNumero implements ICalculator{

	private final int anio;
	
	@Override
	public Object calculate() throws Exception {
		Query query = XPersistence.getManager().createQuery("select max(f.numero) from  Factura f where f.anio=:anio");
		query.setParameter("anio", anio);
		Integer ultimoNumero = (Integer) query.getSingleResult();
		return ultimoNumero == null ? 1 : ultimoNumero +1;
	}
	
	

}
