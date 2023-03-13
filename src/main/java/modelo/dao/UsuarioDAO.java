package modelo.dao;

import modelo.entidades.Usuario;
/*
 * Interfaz que contiene la firma del método para autorizar el acceso de los
 * usuario. Hereda de la interfaz GenericDAO
 */
public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {
	/**
	 * Firma del método para autorizar el acceso de los usuarios 
	 * @param nombre Nombre de usuario ingresado
	 * @param clave Clave el usuario ingresado
	 * @return Objeto de tipo Usuario
	 */
	public Usuario autorizar(String nombre, String clave);

}
