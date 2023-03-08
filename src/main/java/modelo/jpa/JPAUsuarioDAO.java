package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
	}

	@Override
	public Usuario getById(Integer id) {
		return null;
	}

	@Override
	public List<Usuario> get() {
		return null;
	}

	@Override
	public List<Usuario> get(String[] attributes, String[] values) {
		return null;
	}

	@Override
	public List<Usuario> get(String[] attributes, String[] values, String order, int index, int size) {
		return null;
	}

	@Override
	public void create(Usuario entity) {
	}

	@Override
	public void update(Usuario entity) {
	}

	@Override
	public void delete(Usuario entity) {
	}

	@Override
	public void deleteByID(Integer id) {
	}
	
	@Override
	public Usuario autorizar(String nombre, String clave) {
		String JPQL = "SELECT p FROM Persona p WHERE p.clave= :clave AND p.nombre= :nombre";
		Query query = em.createQuery(JPQL);
		query.setParameter("clave", clave);
		query.setParameter("nombre", nombre);
		Usuario persona = null;
		try {
			persona = (Usuario) query.getSingleResult();
		} catch(Exception e) {
			persona = null;
		}
		return persona;
	}

}
