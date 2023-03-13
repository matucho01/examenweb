package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.dto.CuentaDTO;
import modelo.entidades.Cuenta;
import modelo.entidades.Usuario;
import utilidades.Mes;

/**
 * Servlet se encarga de recibir la interacción con el Dashboard
 * Envía a la vista la información de las cuentas según el mes
 *
 */
@WebServlet("/DashboardController")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor vacío de la clase
	 */
	public DashboardController() {
		super();
	}
	
	/**
	 * Recibe las peticiones realizadas por método GET y las redirige al método rutear
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ruteador(request, response);
	}

	/**
	 * Recibe las peticiones realizadas por método POST y las redirige al método rutear
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ruteador(request, response);
	}

	/**
	 * Redirige la petición hacia el metodo showDashboard o showLogin
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta
	 * @throws ServletException
	 * @throws IOException
	 */
	private void ruteador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ruta = (request.getParameter("ruta") == null ? "ver" : request.getParameter("ruta"));

		switch (ruta) {
		case "ver":
			showDashboard(request, response);
			break;
		case "login":
			showLogin(request, response);
			break;
		}
		
	}

	/**
	 * Redirige hacia la vista de inicion de sesión
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);

	}

	/**
	 * Envía a la vista el usuario logeado y obtiene el mes actual o seleccionado
	 * para filtrar la información de las cuentas y enviar la información de cada
	 * una de las cuentas a la vista
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showDashboard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Usuario usuario = (Usuario)sesion.getAttribute("usuarioLogeado");
		
		int mes = LocalDate.now().getMonth().getValue();

		if (request.getParameter("mes") != null) {
			mes = Integer.parseInt(request.getParameter("mes"));
		}

		List<CuentaDTO> conjuntoingresos = DAOFactory.getFactory().getCuentaDAO().getConsolidadoCuentasIngreso(mes);
		List<CuentaDTO> conjuntogastos = DAOFactory.getFactory().getCuentaDAO().getConsolidadoCuentsEgreso(mes);
		List<Cuenta> conjuntoingresogasto = DAOFactory.getFactory().getCuentaDAO().getConsolidadoCuentasIngresoEgreso();
		
		request.setAttribute("nombreusuario", usuario.getNombre());
		request.setAttribute("messeleccionado", mes);
		request.setAttribute("meses", Mes.getMeses());
		request.setAttribute("ingresos", conjuntoingresos);
		request.setAttribute("egresos", conjuntogastos);
		request.setAttribute("ingresogastos", conjuntoingresogasto);
		request.getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
	}

}
