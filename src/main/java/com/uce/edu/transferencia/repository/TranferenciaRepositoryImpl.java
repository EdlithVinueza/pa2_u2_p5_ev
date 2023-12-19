package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.Transferencia;
@Repository
public class TranferenciaRepositoryImpl implements ITransferenciaRepository{
	private static List<Transferencia> base= new ArrayList<Transferencia>();
	@Override
	public Transferencia selecionar(String nuemro) {
		System.out.println("Seleccionamos: "+ nuemro);
		
		for(Transferencia tranferencia : base) {
			if (tranferencia.getNumero().equals(nuemro)) {
				return tranferencia;
			}
		}
		return null;
	}

	@Override
	public void insertar(Transferencia transferencia) {
		base.add(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
		
	}

	@Override
	public void eliminar(String numero) {
		Transferencia tranferencia = this.selecionar(numero);
		base.remove(tranferencia);
		
	}

	@Override
	public List<Transferencia> selecionarTodo() {
		// TODO Auto-generated method stub
		return base;
	}

}
