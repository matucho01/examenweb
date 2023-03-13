package modelo.jpa;


import java.util.List;

import javax.persistence.Query;

import modelo.dao.CuentaDAO;
import modelo.dto.CuentaDTO;
import modelo.entidades.Cuenta;
import modelo.entidades.CuentaTipo;

/**
 * Clase concreta que hereda los metodos de JPAGenericDAO e implementa los metodos de la 
 * interfaz CuentaDAO
 */
public class JPACuentaDAO extends JPAGenericDAO<Cuenta, Integer> implements CuentaDAO {

	/**
	 * Constructor sin parametros que llama al constructor de clase padre
	 */
	public JPACuentaDAO() {
		super(Cuenta.class);
	}

	/**
	 * Implementacion del metodo getConsolidadoCuentasIngreso, retorna una lista de objetos tipo
	 * CueentaDTO con el consolidado de las cuentas de ingreso segun el mes indicado
	 */
	@Override
	public List<CuentaDTO> getConsolidadoCuentasIngreso(int mes) {
		String JPQL = "SELECT new modelo.dto.CuentaDTO( m.origen.id, m.origen.nombre, SUM(m.valor)) FROM Movimiento m "
				+ "WHERE m.origen.tipo= :tipo AND "
				+ "FUNC('MONTH', m.fecha)= :mes "
				+ "GROUP BY m.origen";
		Query query = em.createQuery(JPQL);
		query.setParameter("tipo", CuentaTipo.INGRESO);
		query.setParameter("mes", mes);
		return query.getResultList();
	}

	/**
	 * Implementacion del metodo getConsolidadoCuentsEgreso, retorna una lista de objetos tipo
	 * CueentaDTO con el consolidado de las cuentas de egreso segun el mes indicado
	 */
	@Override
	public List<CuentaDTO> getConsolidadoCuentsEgreso(int mes) {
		
		String JPQL = "SELECT new modelo.dto.CuentaDTO( m.destino.id, m.destino.nombre, SUM(m.valor)) FROM Movimiento m "
				+ "WHERE m.destino.tipo= :tipo AND "
				+ "FUNC('MONTH', m.fecha)= :mes "
				+ "GROUP BY m.destino";
		Query query = em.createQuery(JPQL);
		query.setParameter("tipo", CuentaTipo.GASTO);
		query.setParameter("mes", mes);
		return query.getResultList();
	}

	/**
	 * Implementacion del metodo getConsolidadoCuentasIngresoEgreso, retorna una lista de objetos tipo
	 * Cuenta de tipo Ingreso-Gasto
	 */
	@Override
	public List<Cuenta> getConsolidadoCuentasIngresoEgreso() {
		String JPQL = "SELECT c FROM Cuenta c "
				+ "WHERE c.tipo= :tipo";
		Query query = em.createQuery(JPQL);
		query.setParameter("tipo", CuentaTipo.INGRESOGASTO);
		return query.getResultList();
	}

	/**
	 * Implementa el metodo getByType, retorna lista ded objetos Tipo Cuenta,
	 * las cuentas son del tipo que se especifique en el parametro
	 */
	@Override
	public List<Cuenta> getByType(CuentaTipo tipo) {
		String JPQL = "SELECT c FROM Cuenta c "
				+ "WHERE c.tipo = :tipo";
		Query query = em.createQuery(JPQL);
		query.setParameter("tipo", tipo);
		return query.getResultList();
	}


	
	

}
