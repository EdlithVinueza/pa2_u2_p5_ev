package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.transferencia.repository.modelo.Transferencia;

public interface ITransferenciaService {
	
	public Transferencia buscar(String numero);
	public void guardar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void eliminar(String numero);
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto);
	public List<Transferencia> visulizarTodo();


}
