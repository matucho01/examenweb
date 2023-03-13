package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;

/**
 * Clase concreta que hereda de JPAGenericDAO e implementa los metodos de la interfaz
 * UsuarioDAO
 */
public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	/**
	 * Constructor de la clase que llama al constructor de su clase padre
	 */
	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	/**
	 * Implementacion del metodo autorizar, compara el nombre y clave del ususario ingresado
	 * con los registros de la unidad de persistencia, si encuentra coincidencias retorna el
	 * objeto del usuario, sino retorna null
	 * @param nombre Nombre del usuario ingresado
	 * @param clave Clave del usuario ingresado
	 * @return Objeto e tipo Usuario o null
	 */
	@Override
	public Usuario autorizar(String nombre, String clave) {
		String JPQL = "SELECT u FROM Usuario u WHERE u.clave= :clave AND u.nombre= :nombre";
		Query query = em.createQuery(JPQL);
		query.setParameter("clave", clave);
		query.setParameter("nombre", nombre);
		Usuario usuario = null;
		try {
			usuario = (Usuario) query.getSingleResult();
		} catch(Exception e) {
			usuario = null;
		}
		return usuario;
	}

}
