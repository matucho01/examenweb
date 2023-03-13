package modelo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import modelo.dao.GenericDAO;
/**
 * Clase concreta que implemeta los metodos de GenericDAO para realizar
 * las operaciones CRUD con las diferentes entidades
 * @param <T> Clase de la entidad
 * @param <ID> Integer identificador del objeto de la entidad
 */
public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {

	/**
	 * Clase de la entidad a la que se le va a dar persistencia
	 */
	private Class<T> persistentClass;
	/**
	 * Interfaz del JPA que se encarga de gestionar las entidaddes
	 */
	protected EntityManager em;

	/**
	 * Constructor que recibe la Clase a la que se le va a persistencia
	 * y crea el EntityManager apuntando a la unidad de persistencia
	 * @param persistentClass Clase de la entidad
	 */
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("examenweb").createEntityManager();
	}

	/**
	 * Guarda el objeto enviado como una tupla en la unidad de persistencia
	 * @param entity Instancia de una entidad 
	 */
	public void create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	/**
	 * Obtiene un objeto de la unidad de persistencia segun 
	 * su Identificaor
	 * @param id Identificador numerico del objeto
	 * @return Objeto de una entidad
	 */
	public T getById(ID id) {
		return em.find(persistentClass, id);
	}

	/**
	 * Realiza la operacion de UPDATE en la unidad de persistencia
	 * con la intancia especificada
	 * @param entity Instancia de una entidad 
	 */
	public void update(T entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}

	}

	/**
	 * Realiza la operacion de DELETE en la unidad de persistencia
	 * eliminando la instancia que se especifique
	 * @param entity Instancia de una entidad 
	 */
	public void delete(T entity) {
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}

	}

	/**
	 * Realiza la operacion de DELETE en la unidad de persistencia
	 * eliminando la instancia especificada con su identificador
	 * @param id Identificador de una instancia de las entidades
	 */
	public void deleteByID(ID id) {
		T entity = this.getById(id);
		if (entity != null)
			this.delete(entity);

	}

	/**
	 * Realiza la operacion de SELECT en la unidad de persistencia
	 * retornano todas las tuplas de una tabla
	 * @return Lista de objetos de una entidad
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> get() {
		// Se crea un criterio de consulta
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
		// Se establece la clausula FROM
		Root<T> root = criteriaQuery.from(this.persistentClass);
		// Se establece la clausula SELECT
		criteriaQuery.select(root); 
		Query query = em.createQuery(criteriaQuery);
		return query.getResultList();
	}



}
