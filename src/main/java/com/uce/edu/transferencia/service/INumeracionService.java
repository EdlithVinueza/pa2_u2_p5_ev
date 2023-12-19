package com.uce.edu.transferencia.service;

import java.util.List;

import com.uce.edu.transferencia.repository.modelo.Numeracion;

public interface INumeracionService {

	public Numeracion buscarContador(long numero);
	public void ingresarContador(Numeracion contadorTransferencia);
	public  void actualizarContador(Numeracion contadorTransferencia);
	public void borrarContador(long numero);
	public String establecerContador();
	public List<Numeracion> visulizarTodoList ();

}