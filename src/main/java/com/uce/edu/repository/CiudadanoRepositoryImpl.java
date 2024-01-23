package com.uce.edu.repository;

import org.hibernate.annotations.processing.SQL;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void insertar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ciudadano);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Ciudadano ciudadano = this.seleccionar(id);
		this.entityManager.remove(ciudadano);

	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado>myQuery=this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula =:cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaCiudadano(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery= this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula = :cedula ", Ciudadano.class);
		myQuery.setParameter("cedula", cedula);
		return (Ciudadano)myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorNacionaliad(String nacionalidad) {
		// TODO Auto-generated method stub
		TypedQuery<Ciudadano>myQuery= this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.nacionalidad = :nacionalidad ", Ciudadano.class);
		myQuery.setParameter("nacionalidad", nacionalidad);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		
		//0. Creamos una instancia de la CriterialNuilder, apartir de un entity Manager interfaz de interaccion con la base de datos
		CriteriaBuilder myCriterianBuilder = this.entityManager.getCriteriaBuilder();
		//1. Determinamos el tipo de retorno que va ha tener mi Consulta --> AQUI recien creamos la intancia 
		CriteriaQuery<Ciudadano> myCriteriaQuery  = myCriterianBuilder.createQuery(Ciudadano.class); //especificamos la clase de retorno
		//2. Contruir el SQL
		//2.1 Determinamos el from mediante una interfaz conocida como {Root}
		//Nota:No necesariamente el from es igual al tipo de retorno
		//Ejemplo --> SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
		Root<Ciudadano> myFrom= myCriteriaQuery.from(Ciudadano.class); //FROM ciudadano 
		//2.2 Contruir las condiciones (WHERE) del SQL
		//En criteria API Query las condiciones se las conoce como "Predicate"
		//c.apellido =:variable
		Predicate condicionApellido = myCriterianBuilder.equal(myFrom.get("apellido"), apellido); //los parametros: a que atributo le voy a aplicar la condicion ()
		
		//3. Contruimos el SQL final
		myCriteriaQuery.select(myFrom).where(condicionApellido);
		
		//4. Ejecutamos la consulta con un typeQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		//0. Creamos una instancia de la interfaz CriteriBuldier a partir de un EM
		CriteriaBuilder myCriterianBuilder = this.entityManager.getCriteriaBuilder();
		//1. Determinamos el tipo de retorno que va ha tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery  = myCriterianBuilder.createQuery(Ciudadano.class);
		
		//2. Contriur SQUL
		//2.1 Determinamos el FROM
		Root<Ciudadano> myFrom= myCriteriaQuery.from(Ciudadano.class);
		
		//2.2 Contruimo slas condiciones del (WHERE)
		
		Predicate condicionGenerica = null;

		if (cedula.startsWith("17")) {
			condicionGenerica = myCriterianBuilder.equal(myFrom.get("nombre"), nombre);
		}
		else if (cedula.startsWith("05")) {
			condicionGenerica = myCriterianBuilder.equal(myFrom.get("apellido"), apellido);
		}
		else {
			condicionGenerica = myCriterianBuilder.equal(myFrom.get("cedula"), cedula);
		}
		
		//3. Contruir el SQL final
		myCriteriaQuery.select(myFrom).where(condicionGenerica);
		
		//4. Ejecutamos la consulta con un typeQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
				
		return myTypedQuery.getSingleResult();
	}
	
	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		//0. Creamos una instancia de la interfaz CriteriBuldier a partir de un EM
		CriteriaBuilder myCriterianBuilder = this.entityManager.getCriteriaBuilder();
		//1. Determinamos el tipo de retorno que va ha tener mi Consulta
		CriteriaQuery<Ciudadano> myCriteriaQuery  = myCriterianBuilder.createQuery(Ciudadano.class);
		
		//2. Contriur SQUL
		//2.1 Determinamos el FROM
		Root<Ciudadano> myFrom= myCriteriaQuery.from(Ciudadano.class);
		
		//2.2 Contruimo slas condiciones del (WHERE)
		
		Predicate condicionTotal = null;
		//c.nombre = :nombre
		Predicate condicionNombre = myCriterianBuilder.equal(myFrom.get("nombre"), nombre);
		//c.apellido = :apellido
		Predicate condicionApellido = myCriterianBuilder.equal(myFrom.get("apellido"), apellido);
		
		if (cedula.startsWith("17")) {
			//c.nombre = :nombre or c.apellido = :apellido
			condicionTotal = myCriterianBuilder.or(condicionNombre,condicionApellido);
		}
		else if (cedula.startsWith("05")) {
			//c.nombre = :nombre and c.apellido = :apellido
			condicionTotal = myCriterianBuilder.and(condicionNombre,condicionApellido);
		}

		//3. Contruir el SQL final
		myCriteriaQuery.select(myFrom).where(condicionTotal);
		
		//4. Ejecutamos la consulta con un typeQuery
		TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
				
		return myTypedQuery.getSingleResult();
	}

}
