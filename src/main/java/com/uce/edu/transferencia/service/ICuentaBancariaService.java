package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;


public interface ICuentaBancariaService {
	public CuentaBancaria buscar(String nuemro);
	public void guardar(CuentaBancaria cuentaBancaria);
	public  void actualizar(CuentaBancaria cuentaBancaria);
	public void eliminar(String numero);
	///Depositar e implementar un descuento del 10 porciento
	public void depositar(String numero, BigDecimal deposito);
}
