package com.uce.edu.transferencia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.INumeracionRepository;
import com.uce.edu.transferencia.repository.modelo.Numeracion;
@Service
public class NumeracionServiceImpl implements INumeracionService{

	@Autowired
	private INumeracionRepository iContadorTranferenciaRepository;

	@Override
	public Numeracion buscarContador(long numero) {
		// TODO Auto-generated method stub
		return this.iContadorTranferenciaRepository.selecionar(numero);
	}

	@Override
	public void ingresarContador(Numeracion contadorTransferencia) {
		// TODO Auto-generated method stub
		this.iContadorTranferenciaRepository.insertar(contadorTransferencia);

	}

	@Override
	public void actualizarContador(Numeracion contadorTransferencia) {
		// TODO Auto-generated method stub
		this.iContadorTranferenciaRepository.actualizar(contadorTransferencia);
	}

	@Override
	public void borrarContador(long numero) {
		// TODO Auto-generated method stub
		this.iContadorTranferenciaRepository.eliminar(numero);
	}

	@Override
	public String establecerContador() {
		long tmp=0;
		List<Numeracion> listTmpList = this.visulizarTodoList();
		if (listTmpList.isEmpty()) {
			Numeracion contadorTmp = new Numeracion();
			Long t = contadorTmp.getContador();
			this.iContadorTranferenciaRepository.insertar(contadorTmp);
			return String.valueOf(t);
		}
		else {
			Numeracion a = listTmpList.get(listTmpList.size()-1);
			tmp = a.getContador();
			Numeracion b = new Numeracion();
			b.setContador(tmp+1);
			this.iContadorTranferenciaRepository.insertar(b);
			return String.valueOf(tmp+1);
		}

	}

	@Override
	public List<Numeracion> visulizarTodoList() {
		// TODO Auto-generated method stub
		return iContadorTranferenciaRepository.selecionarTodo();
	}

}