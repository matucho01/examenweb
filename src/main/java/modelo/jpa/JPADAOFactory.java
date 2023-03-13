package modelo.jpa;

import modelo.dao.CuentaDAO;
import modelo.dao.DAOFactory;
import modelo.dao.MovimientoDAO;
import modelo.dao.UsuarioDAO;
/**
 * Clase concreta que hereda de DAOFActory e implementa sus metodos
 * abstractos
 */
public class JPADAOFactory extends DAOFactory {

	/**
	 * Implementacion del metodo getUsuarioDAO, returna una instancia de
	 * tipo JPAUsuarioDAO
	 */
	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

	/**
	 * Implementacion del metodo getCuentaDAO, returna una instancia de
	 * tipo JPACuentaDAO
	 */
	@Override
	public CuentaDAO getCuentaDAO() {
		return new JPACuentaDAO();
	}

	/**
	 * Implementacion del metodo getMovimientoDAO, returna una instancia de
	 * tipo JPAMovimientoDAO
	 */
	@Override
	public MovimientoDAO getMovimientoDAO() {
		return new JPAMovimientoDAO();
	}

}
