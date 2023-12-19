package com.uce.edu.transferencia.repository.modelo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope (value = ConfigurableBeanFactory.SCOPE_SINGLETON)

public class Numeracion {

	private long contador = 156974;

	public long getContador() {
		return contador;
	}
	public void setContador(long contador) {
		this.contador = contador;
	}

}