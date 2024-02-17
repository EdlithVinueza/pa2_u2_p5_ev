package com.uce.edu.demo.funcional;

public class PersonaConsumerImpl implements IPersonaConsumer<String> {

	@Override
	public void accept(String arg) {
		System.out.println("Se inserta");
		System.out.println(arg);
		
	}

}
