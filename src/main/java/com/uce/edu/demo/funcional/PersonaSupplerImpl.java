package com.uce.edu.demo.funcional;

public class PersonaSupplerImpl implements IPersonaSupplier<String> {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula = "159357147963";
		cedula = cedula + " privincia";
		return cedula;
	}

}
