package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.Numeracion;

@Repository
public class NumeracionRepositoryImpl implements INumeracionRepository {

	private static List<Numeracion> base= new ArrayList<Numeracion>();

	@Override
	public Numeracion selecionar(long numero) {
		// TODO Auto-generated method stub
		for(Numeracion contador : base) {
			if (contador.getContador()==numero) {
				return contador;
			}
		}
		return null;
	}

	@Override
	public void insertar(Numeracion contadorTransferencia) {
		// TODO Auto-generated method stub
		base.add(contadorTransferencia);
	}

	@Override
	public void actualizar(Numeracion contadorTransferencia) {
		// TODO Auto-generated method stub
		this.eliminar(contadorTransferencia.getContador());
		this.insertar(contadorTransferencia);
	}

	@Override
	public void eliminar(long numero) {
		// TODO Auto-generated method stub
		Numeracion contadorTransferencia = this.selecionar(numero);
		base.remove(contadorTransferencia);
	}

	@Override
	public List<Numeracion> selecionarTodo() {
		// TODO Auto-generated method stub
		return base;
	}

}