package br.com.jdbc.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.jdbc.entity.Funcionario;

public class FuncionarioDAO {
	public void cadastrarFuncionario(Funcionario func) throws SQLException {
        
		//Buscando uma conexão com o Banco de Dados
        Connection con = ConexaoBD.getConnection();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //String que receberá instrução SQL
            String sql;

            /* Montando a instrução INSERT para inserir
             um objeto pVO no Banco MySQL */
            sql = "insert into funcionario(codigo,nome,cargo,descricao_cargo,setor,salario)"
                    + "values(null,'" + func.getNome() + "'," + func.getCargo() + "," + func.getDescricao_cargo() + ","+ func.getSetor() +"," + func.getSalario() +")";

            //Executando o sql
            stat.execute(sql);

        } catch (SQLException se) {
            throw new SQLException("Erro ao inserir dados no Banco de Dados! " + se.getMessage());
        } finally {
            //Encerrando as conexões
            stat.close();
            con.close();
        }//fecha finally
    }//fecha método cadastrarProduto
}
