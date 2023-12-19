package com.uce.edu.transferencia.repository;

import java.util.List;

import com.uce.edu.transferencia.repository.modelo.Numeracion;

public interface INumeracionRepository {

	public Numeracion selecionar(long numero);
	public void insertar(Numeracion contadorTransferencia);
	public  void actualizar(Numeracion contadorTransferencia);
	public void eliminar(long numero);
	public List<Numeracion> selecionarTodo();

}