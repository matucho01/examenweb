package modelo.jpa;

import modelo.dao.MovimientoDAO;
import modelo.entidades.Movimiento;
/**
 * Clase concreta que hereda de JPAGenericDAO e implementa la interfaz MovimientoDAO
 */
public class JPAMovimientoDAO extends JPAGenericDAO<Movimiento, Integer> implements MovimientoDAO {

	/**
	 * Constructor de la clase que llama al constructor de su clase padre
	 */
	public JPAMovimientoDAO() {
		super(Movimiento.class);
	}

}
