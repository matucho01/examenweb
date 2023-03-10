package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.Cuenta;
import modelo.entidades.CuentaTipo;
import modelo.entidades.Movimiento;
import modelo.entidades.Usuario;

/**
 * Servlet se encarga de recibir la interacción con las vistas de ingreso y egreso,
 * envía a las vistas de ingreso y egreso las cuentas según su tipo según como les corresponda.
 * Actualiza los montos totales de las cuentas según el movimiento que se realice.
 */
@WebServlet("/RegistrarMovimientoController")
public class RegistrarMovimientoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Constructor vacío de la clase
	 */
    public RegistrarMovimientoController() {
        super();
    }

    /**
	 * Recibe las peticiones realizadas por método GET y las redirige al método rutear
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ruteador(request, response);
	}

	/**
	 * Recibe las peticiones realizadas por método POST y las redirige al método rutear
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ruteador(request, response);
	}
	
	/**
	 * Redirige la petición hacia los metodos showIngreso, saveIngreso, showEgreso y saveEgreso
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = (request.getParameter("ruta")==null?"":request.getParameter("ruta"));
		switch(ruta) {
		case "ingreso":
			showIngreso(request, response);
			break;
		case "guardarIngreso":
			saveIngreso(request, response);
			break;
		case "egreso":
			showEgreso(request, response);
			break;
		case "guardarEgreso":
			saveEgreso(request, response);
			break;
		}
	}

	/**
	 * Obtiene las cuentas de origen y destino seleccionadas para el egreso, el concepto, 
	 * la fecha y el valor del egreso y con ellos crea y guarda un nuevo movimiento.
	 * Actualiza el valor de las cuentas según corresponda y regresa al dashboard o a una
	 * ventana de error en el caso de ocurrir uno.
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void saveEgreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCuentaOrigen = Integer.parseInt(request.getParameter("cuentaingresoegreso"));
		Cuenta cuentaOrigen = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaOrigen);
		int idCuentaDestino = Integer.parseInt(request.getParameter("cuentaegreso"));
		Cuenta cuentaDestino = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaDestino);
		String concepto = request.getParameter("concepto");
		Date fecha = null;
		
		try {
			fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double valor = Double.parseDouble(request.getParameter("valor"));
		
		if (cuentaOrigen.getTotal() >= valor) {
			cuentaOrigen.setTotal(cuentaOrigen.getTotal()-valor);
			cuentaDestino.setTotal(cuentaDestino.getTotal()-valor);
			
			Movimiento movimiento = new Movimiento(concepto, valor, fecha, cuentaOrigen, cuentaDestino);
			DAOFactory.getFactory().getMovimientoDAO().create(movimiento);
			
			DAOFactory.getFactory().getCuentaDAO().update(cuentaOrigen);
			DAOFactory.getFactory().getCuentaDAO().update(cuentaDestino);
		} else {
			//request.getRequestDispatcher("RegistrarMovimientoController?ruta=egreso").forward(request, response);
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("DashboardController?ruta=ver").forward(request, response);
		
	}

	/**
	 * Envía a la vista de egreso el usuario logeado, las cuentas de ingreso-gasto y las 
	 * cuentas de gasto
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showEgreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Usuario usuario = (Usuario)sesion.getAttribute("usuarioLogeado");
		List<Cuenta> cuentasIngresoEgreso = DAOFactory.getFactory().getCuentaDAO().getByType(CuentaTipo.INGRESOGASTO);
		List<Cuenta> cuentasEgreso = DAOFactory.getFactory().getCuentaDAO().getByType(CuentaTipo.GASTO);
		
		request.setAttribute("nombreusuario", usuario.getNombre());
		request.setAttribute("cuentasingresoegreso", cuentasIngresoEgreso);
		request.setAttribute("cuentasegreso", cuentasEgreso);
		
		request.getRequestDispatcher("/jsp/egreso.jsp").forward(request, response);
		
	}

	/**
	 * Obtiene las cuentas de origen y destino seleccionadas para el ingreso, el concepto, 
	 * la fecha y el valor del ingreso y con ellos crea y guarda un nuevo movimiento.
	 * Actualiza el valor de las cuentas según corresponda y regresa al dashboard.
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void saveIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int idCuentaOrigen = Integer.parseInt(request.getParameter("cuentaingreso"));
		Cuenta cuentaOrigen = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaOrigen);
		int idCuentaDestino = Integer.parseInt(request.getParameter("cuentaingresoegreso"));
		Cuenta cuentaDestino = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaDestino);
		String concepto = request.getParameter("concepto");
		Date fecha = null;
		
		try {
			fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double valor = Double.parseDouble(request.getParameter("valor"));
		
		cuentaOrigen.setTotal(cuentaOrigen.getTotal()+valor);
		cuentaDestino.setTotal(cuentaDestino.getTotal()+valor);
		
		Movimiento movimiento = new Movimiento(concepto, valor, fecha, cuentaOrigen, cuentaDestino);
		DAOFactory.getFactory().getMovimientoDAO().create(movimiento);
		
		DAOFactory.getFactory().getCuentaDAO().update(cuentaOrigen);
		DAOFactory.getFactory().getCuentaDAO().update(cuentaDestino);
		request.getRequestDispatcher("DashboardController?ruta=ver").forward(request, response);
	}

	/**
	 * Envía a la vista de ingreso el usuario logeado, las cuentas de ingreso y las 
	 * cuentas de ingreso-gasto
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Usuario usuario = (Usuario)sesion.getAttribute("usuarioLogeado");
		List<Cuenta> cuentasIngreso = DAOFactory.getFactory().getCuentaDAO().getByType(CuentaTipo.INGRESO);
		List<Cuenta> cuentasIngresoEgreso = DAOFactory.getFactory().getCuentaDAO().getByType(CuentaTipo.INGRESOGASTO);
		
		request.setAttribute("nombreusuario", usuario.getNombre());
		request.setAttribute("cuentasingreso", cuentasIngreso);
		request.setAttribute("cuentasingresoegreso", cuentasIngresoEgreso);
		
		request.getRequestDispatcher("/jsp/ingreso.jsp").forward(request, response);
	}

}
