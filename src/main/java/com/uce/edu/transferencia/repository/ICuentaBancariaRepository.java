package com.uce.edu.transferencia.repository;



import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	public CuentaBancaria selecionar(String nuemro);
	public void insertar(CuentaBancaria cuentaBancaria);
	public  void actualizar(CuentaBancaria cuentaBancaria);
	public void eliminar(String numero);
	
}
