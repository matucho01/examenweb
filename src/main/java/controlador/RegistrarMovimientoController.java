package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Cuenta;
import modelo.entidades.CuentaTipo;

/**
 * Servlet implementation class RegistrarMovimientoController
 */
@WebServlet("/RegistrarMovimientoController")
public class RegistrarMovimientoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrarMovimientoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ruteador(request, response);
	}
	
	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ruta = (request.getParameter("ruta")==null?"":request.getParameter("ruta"));
		switch(ruta) {
		case "ingreso":
			showIngreso(request, response);
			break;
		case "guardarIngreso":
			saveIngreso(request, response);
			break;
		}
	}

	private void saveIngreso(HttpServletRequest request, HttpServletResponse response) {
		int idCuentaOrigen = Integer.parseInt(request.getParameter("cuentaingreso"));
		int idCuentaDestino = Integer.parseInt(request.getParameter("cuentaingresoegreso"));
		String concepto = request.getParameter("concepto");
		LocalDate fecha = request.getParameter("fecha");
		
	}

	private void showIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cuenta> cuentasIngreso = DAOFactory.getFactory().getCuentaDAO().getByType(CuentaTipo.INGRESO);
		List<Cuenta> cuentasIngresoEgreso = DAOFactory.getFactory().getCuentaDAO().getByType(CuentaTipo.INGRESOGASTO);
		
		request.setAttribute("cuentasingreso", cuentasIngreso);
		request.setAttribute("cuentasingresoegreso", cuentasIngresoEgreso);
		
		request.getRequestDispatcher("/jsp/ingreso.jsp").forward(request, response);
	}

}
