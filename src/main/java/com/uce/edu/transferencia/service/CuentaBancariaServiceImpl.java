package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	public CuentaBancaria buscar(String nuemro) {
		// TODO Auto-generated method stub
		return this.iCuentaBancariaRepository.selecionar(nuemro);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.insertar(cuentaBancaria);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.eliminar(numero);
	}

	@Override
	public void depositar(String numero,BigDecimal deposito) {
		BigDecimal montoRestar = deposito.multiply(new BigDecimal(0.1));
		BigDecimal depositoFinal = deposito.subtract(montoRestar);
		CuentaBancaria ctaTmp = this.buscar(numero);
		BigDecimal saldoActual = ctaTmp.getSaldo();
		BigDecimal nuevoSaldo = saldoActual.add(depositoFinal);
		ctaTmp.setSaldo(nuevoSaldo);
		actualizar(ctaTmp);
	}

}
