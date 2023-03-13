package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.DAOFactory;
import modelo.entidades.Usuario;
/**
 * 
 * Servlet se encarga de recibir la interacción con la pantalla de Login para la
 * autorización e inicio de sesión de los usuarios
 *
 */
@WebServlet("/AutorizarController")
public class AutorizarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor vacío de la clase
	 */
	public AutorizarController() {
		super();
	}

	/**
	 * Recibe las peticiones realizadas por método GET y las redirige al método rutear
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		rutear(request, response);
	}

	/**
	 * Recibe las peticiones realizadas por método POST y las redirige al método rutear
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		rutear(request, response);
	}
	
	/**
	 * Redirige la petición hacia el metodo ingresar o login 
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta
	 * @throws ServletException
	 * @throws IOException
	 */
	private void rutear(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String ruta = (request.getParameter("ruta") == null) ? "ingresar" : request.getParameter("ruta");
		
		switch(ruta) {
		case "ingresar":
			this.ingresar(request, response);
			break;
		case "login":
			this.login(request, response);
			break;
		}
	}

	/**
	 * Obtiene el usuario y contraseña enviado desde la vista, realiza la 
	 * autenticación y en el caso de ser correcta se crea la sesión con el 
	 * usuario ingresado y se accede al dashboard
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1.- Obtengo parametros
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("password");
		
		// 2.- Llamo al modelo
		Usuario usuarioAutorizado = null;
		usuarioAutorizado = DAOFactory.getFactory().getUsuarioDAO().autorizar(usuario, clave);
		if (usuarioAutorizado != null) {
			// Creo la sesion y le dejo pasar
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuarioLogeado", usuarioAutorizado);
			
			// 3.- Llamo al siguiente controlador
			request.getRequestDispatcher("DashboardController?ruta=ver").forward(request, response);
			
		} else {
			// Me la regreso al Login
			response.sendRedirect("AutorizarController?ruta=ingresar");
		}
		
	}

	/**
	 * Redirige hacia la vista de inicion de sesión
	 * @param request contiene los parámetros enviados por la vista
	 * @param response contiene los parámetros que se envíen como respuesta
	 * @throws ServletException
	 * @throws IOException
	 */
	private void ingresar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		
	}

}
