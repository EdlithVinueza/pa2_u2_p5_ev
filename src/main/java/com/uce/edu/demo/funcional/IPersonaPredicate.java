package com.uce.edu.demo.funcional;
@FunctionalInterface
public interface IPersonaPredicate <T> {
	public boolean evaluar (T arg);

}
