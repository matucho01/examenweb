package controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Cuenta;
import modelo.entidades.CuentaTipo;
import modelo.entidades.Movimiento;

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

	private void saveIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCuentaOrigen = Integer.parseInt(request.getParameter("cuentaingreso"));
		Cuenta cuentaOrigen = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaOrigen);
		int idCuentaDestino = Integer.parseInt(request.getParameter("cuentaingresoegreso"));
		Cuenta cuentaDestino = DAOFactory.getFactory().getCuentaDAO().getById(idCuentaDestino);
		String concepto = request.getParameter("concepto");
		Date fecha = new Date(request.getParameter("fecha"));
		double valor = Double.parseDouble(request.getParameter("valor"));
		
		cuentaOrigen.setTotal(cuentaOrigen.getTotal()+valor);
		cuentaDestino.setTotal(cuentaDestino.getTotal()+valor);
		
		Movimiento movimiento = new Movimiento(concepto, valor, fecha, cuentaOrigen, cuentaDestino);
		DAOFactory.getFactory().getMovimientoDAO().create(movimiento);
		
		DAOFactory.getFactory().getCuentaDAO().update(cuentaDestino);
		request.getRequestDispatcher("DashboardController").forward(request, response);
	}

	private void showIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cuenta> cuentasIngreso = DAOFactory.getFactory().getCuentaDAO().getByType(CuentaTipo.INGRESO);
		List<Cuenta> cuentasIngresoEgreso = DAOFactory.getFactory().getCuentaDAO().getByType(CuentaTipo.INGRESOGASTO);
		
		request.setAttribute("cuentasingreso", cuentasIngreso);
		request.setAttribute("cuentasingresoegreso", cuentasIngresoEgreso);
		
		request.getRequestDispatcher("/jsp/ingreso.jsp").forward(request, response);
	}

}
