package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.CuentasService;

/**
 * Servlet implementation class doRegistrarCuenta
 */
@WebServlet("/RegistrarCuentaAction")
public class RegistrarCuentaAction extends HttpServlet {
	@Autowired
	CuentasService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyecci�n
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numeroCuenta=Integer.parseInt(request.getParameter("numeroCuenta"));
		int dni=(Integer)(request.getSession().getAttribute("dni"));
		service.actualizarCuenta(numeroCuenta, dni);
	}

}
