package com.uce.edu.demo.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {
	public T aplicar(T arg);

}
