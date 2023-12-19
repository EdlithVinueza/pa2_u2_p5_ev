package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TranferenciaServiceImpl implements ITransferenciaService {
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository; 
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService; 
	@Autowired
	private INumeracionService iNumeracionService; 
	
	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.selecionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);
	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		// 1. Buscar cuenta Origen
		CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.selecionar(numeroOrigen);
		//System.out.println(ctaOrigen.hashCode());
		// 2. Consultar el saldo
		BigDecimal saldoOrige=ctaOrigen.getSaldo();
		// 3. Validar el saldo
		if (saldoOrige.compareTo(monto)>=0) {
			// 4. Restar el monto
			BigDecimal nuevoSaldoOrige = saldoOrige.subtract(monto);
			// 5. Actualizar cuenta Origen
			ctaOrigen.setSaldo(nuevoSaldoOrige);
			this.iCuentaBancariaRepository.actualizar(ctaOrigen);
			// 6. Buscar cuenta destino
			CuentaBancaria ctaDestino=this.iCuentaBancariaRepository.selecionar(numeroDestino);
			//System.out.println(ctaDestino.hashCode());
			// 7  Consultar saldo
			// 8. Sumar el monto
			// 9. Actualiar cuenta destino
			this.iCuentaBancariaService.depositar(ctaDestino.getNumero(), monto);
			
			// 10. Crear la transferencia
			String num = this.iNumeracionService.establecerContador();
			Transferencia transferencia = new Transferencia();
			transferencia.setCuentaOrigen(ctaOrigen);
			transferencia.setCuentaDestino(ctaDestino);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setNumero(num);
			
			this.iTransferenciaRepository.insertar(transferencia);
			System.out.println("¡Tranferencia realizada con exito!");
		}
		else {
			System.out.println("Saldo no disponible");
		}
	}

	@Override
	public List<Transferencia> visulizarTodo() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.selecionarTodo();
	}

}
