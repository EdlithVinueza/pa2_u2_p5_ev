package com.uce.edu.demo.funcional;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Supplier
		
		System.out.println("****************SUPPLIER****************");
		// Clase
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplerImpl();
		System.out.println(supplierClase.getId());
		
		// Lambdas
		System.out.println("Lambdas 1 ");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "159357147963";
			return cedula = cedula + " canton";
		};
		System.out.println(supplierLambda.getId());
		
		System.out.println("Lambdas 2 ");
		IPersonaSupplier<String> supplierLambda2 = () -> "159357147963"+" pais";
		System.out.println(supplierLambda2.getId());
		
		System.out.println("Lambdas 3 ");
		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 =Integer.valueOf(100);
			valor1= valor1 * Integer.valueOf(50)/Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getId());
		
		//Metodos referenciados
		System.out.println("****************CONSUMER****************");
		//Clase
		System.out.println("Clase");
		IPersonaConsumer<String> consummerClase = new PersonaConsumerImpl();
		consummerClase.accept("Profesor");
		//Lambdas
		System.out.println("Lambdas");
		IPersonaConsumer<String> consummerLambdaConsumer = (cadena) -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		} ;
		
		consummerLambdaConsumer.accept("Profesor");
		System.out.println("****************PREDICATE****************");
		System.out.println("Lambdas 1");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));
		System.out.println("Lambdas 2");
		IPersonaPredicate<String> predicateLambda2 = letra -> "Edlith".contains(letra);
		System.out.println(predicateLambda2.evaluar("E"));
	}

}
