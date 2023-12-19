package com.uce.edu.transferencia.repository.modelo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CuentaBancaria {
	private String numero;
	private String cedulaPropietario;
	private BigDecimal saldoBig;
	
	//SET Y GET
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCedulaPropietario() {
		return cedulaPropietario;
	}
	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}
	public BigDecimal getSaldo() {
		return saldoBig;
	}
	public void setSaldo(BigDecimal saldoBig) {
		this.saldoBig = saldoBig;
	}
	@Override
	public String toString() {
		return "CuentaBancaria [numero=" + numero + ", cedulaPropietario=" + cedulaPropietario + ", saldoBig="
				+ saldoBig + "]";
	}
	
	

}
