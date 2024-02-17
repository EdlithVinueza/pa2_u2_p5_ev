package com.uce.edu.demo.funcional;
@FunctionalInterface
public interface IPersonaFunction <T,R> {
	public T aplicar(R arg);

}
