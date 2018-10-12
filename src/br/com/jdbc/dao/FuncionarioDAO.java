package br.com.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.jdbc.entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncionarioDAO {

	public List<Funcionario> listarFuncionarios(Connection conn) throws SQLException {
		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Funcionario func = null;

		List<Funcionario> lista = new ArrayList<Funcionario>();

		try {
			sql.append("SELECT * FROM funcionario ");
			sql.append("ORDER BY codigo");
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				func = new Funcionario();
				func.setCodigo(rs.getInt("codigo"));
				func.setNome(rs.getString("nome").trim());
				func.setCargo(rs.getInt("cargo"));
				func.setDescricao_cargo(rs.getString("descricao_cargo"));
				func.setSetor(rs.getString("setor"));
				func.setSalario(rs.getDouble("salario"));
				lista.add(func);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("(listarFuncionarios) - Erro : " + e.getMessage());
		} finally {
			try {ps.close();}catch(SQLException e){  }
			if(rs != null) {
				try {rs.close();}catch(SQLException e){ }
			}
			ps = null;
			rs = null;
			sql = null;
		}
		return lista;
	}
	
	
	public void inserir(Connection conn, Funcionario funcionario) throws SQLException {

		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		
		try {
			int qtdeGravados = listarFuncionarios(conn).size();
			qtdeGravados++;
			
			sql.delete(0, sql.length());
			sql.append("INSERT INTO funcionario (codigo, nome, cargo, descricao_cargo,"+ "setor,salario)");
			sql.append("                                 VALUES (?,?,?,?,?,?)");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, qtdeGravados);
			ps.setString(2, funcionario.getNome());
			ps.setInt(3, funcionario.getCargo());
			ps.setString(4, funcionario.getDescricao_cargo());
			ps.setString(5, funcionario.getSetor());
			ps.setDouble(6, funcionario.getSalario());
			ps.executeUpdate();
			
		} finally {
			try{
				ps.close();
				ps = null;
			}catch(SQLException e){
					
			}
			ps = null;
			sql = null;
		}
	}

}
