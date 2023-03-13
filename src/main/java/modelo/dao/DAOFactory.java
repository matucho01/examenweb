package modelo.dao;

import modelo.jpa.JPADAOFactory;
/**
 * Clase abstracta, factoria para obtener instancias de
 * UsuarioDAO, CuentaDAO y MovimientoDAO 
 */
public abstract class DAOFactory {

	/**
	 * Instancia unica de DAOFactory
	 */
    protected static DAOFactory factory = new JPADAOFactory();

    /**
     * Retorna la intancia unica de la clase
     * @return Atributo factory de la clase
     */
    public static DAOFactory getFactory() {
        return factory;
    }

    /**
     * Firma el método para obtener una instancia de UsuarioDAO
     * @return Instancia de UsuarioDAO
     */
    public abstract UsuarioDAO getUsuarioDAO();
    
    /**
     * Firma el método para obtener una instancia de CuentaDAO
     * @return Instancia de CuentaDAO
     */
    public abstract CuentaDAO getCuentaDAO();
    
    /**
     * Firma el método para obtener una instancia de MovimientoDAO
     * @return Instancia de MovimientoDAO
     */
    public abstract MovimientoDAO getMovimientoDAO();


}