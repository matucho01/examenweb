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

@WebServlet("/AutorizarController")
public class AutorizarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AutorizarController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		rutear(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		rutear(request, response);
	}

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

	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1.- Obtengo parametros
		String usuario = request.getParameter("username");
		String clave = request.getParameter("password");
		
		// 2.- Llamo al modelo
		Usuario personaAutorizada = null;
		personaAutorizada = DAOFactory.getFactory().getUsuarioDAO().autorizar(usuario, clave);
		if (personaAutorizada != null) {
			// Creo la sesion y le dejo pasar
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuarioLogeado", personaAutorizada);
			
			// 3.- Llamo al siguiente controlador
			request.getRequestDispatcher("DashboardController?ruta=ver").forward(request, response);
			
		} else {
			// Me la regreso al Login
			response.sendRedirect("jsp/login.jsp");
		}
		
		// 3.- Llamo a la vista
		
	}

	private void ingresar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		
	}

}
