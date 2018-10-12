package br.com.jdbc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jdbc.dao.ConexaoBD;
import br.com.jdbc.dao.FuncionarioDAO;
import br.com.jdbc.entity.Funcionario;

/**
 * Servlet implementation class CadastroFuncionario
 */
@WebServlet("/CadastroFuncionario")
public class CadastroFuncionario extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public CadastroFuncionario() {
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	 
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("passando pelo método post");
		Connection conn = ConexaoBD.getConnection();
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		
		try {
			Funcionario func = new Funcionario();
			func.setNome(req.getParameter("nome"));
			func.setDescricao_cargo(req.getParameter("descricao_cargo"));
			func.setSetor("nove");
			func.setCargo(12);
			func.setSalario(144022);
			
			funcDAO.inserir(conn,func);
			System.out.println("oi");
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
		
	}
}
