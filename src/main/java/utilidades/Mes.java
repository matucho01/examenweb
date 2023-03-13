package utilidades;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que contiene los meses del año
 */
public class Mes {
	/**
	 * Numeracion del mes
	 */
	private int id;
	/**
	 * Nombre del mes
	 */
	private String nombre;
	
	/**
	 * Constructor vacio
	 */
	public Mes() {}

	/**
	 * Constructor con parametros
	 * @param id Numero de mes
	 * @param nombre Nombre del mes
	 */
	public Mes(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * @return Numero del mes
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id Numero del mes
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Nombre del mes
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Nombre del mes
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que devuelve todos los meses del año
	 * @return Lista con objejtos tipo Mes
	 */
	public static List<Mes> getMeses() {
		List<Mes> meses = new ArrayList<Mes>();
		meses.add(new Mes(1, "Enero"));
		meses.add(new Mes(2, "Febrero"));
		meses.add(new Mes(3, "Marzo"));
		meses.add(new Mes(4, "Abril"));
		meses.add(new Mes(5, "Mayo"));
		meses.add(new Mes(6, "Junio"));
		meses.add(new Mes(7, "Julio"));
		meses.add(new Mes(8, "Agosto"));
		meses.add(new Mes(9, "Septiembre"));
		meses.add(new Mes(10, "Octubre"));
		meses.add(new Mes(11, "Noviembre"));
		meses.add(new Mes(12, "Diciembre"));
		return meses;
	}
}
