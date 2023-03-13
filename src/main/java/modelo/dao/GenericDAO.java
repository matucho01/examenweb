package modelo.dao;

import java.util.List;
/**
 * Interfaz que contiene las firmas de lo métodos 
 * que realizan las operaciones CRUD basicas para cada entidad.
 * @param <T> entidad Cuenta, Movimiento o Usuario
 * @param <ID> Integer idetificador de cada objeto de las entidades
 */
public interface GenericDAO<T, ID> {
	/**
	 * Firma del método que obtiene un objeto según su id
	 * @param id Integer identificador del objeto a obtener
	 * @return Objeto de tipo Cuenta, Movimiento o Usuario
	 */
	public T getById(ID id);
	
	/**
	 * Firma del método que obtiene todos los objetos de una entidad
	 * @return Lista con lo objetos
	 */
	public List<T> get();
	
	/**
	 * Firma del método que crea un objeto en la unidad de persistencia
	 * @param entity entidad Cuenta, Movimiento o Usuario
	 */
	public void create(T entity);
	
	/**
	 * Firma del método que actualiza un objeto en la unidad de persistencia
	 * @param entity entidad Cuenta, Movimiento o Usuario
	 */
	public void update(T entity);
	
	/**
	 * Firma del método que elimina un objeto de la unidad de persistencia 
	 * @param entity entidad Cuenta, Movimiento o Usuario
	 */
	public void delete(T entity);
	
	/**
	 * Firma del método que elimina un objeto de la unidad de persistencia según su id
	 * @param id  idetificador del objeto
	 */
	public void deleteByID(ID id);
	
}