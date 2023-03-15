package com.wprotheus.pbw2_aula02.model.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMySql implements ConexaoJDBC
{
	public static void main(String[] args)
	{
		System.out.println(new ConexaoMySql().criarConexao());
	}
	@Override
	public Connection criarConexao()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/pbw2";
			String usuario = "root";
			String senha = "12345678";

			return DriverManager.getConnection(url, usuario, senha);
		}
		catch (ClassNotFoundException | SQLException ex)
		{
			Logger.getLogger(ConexaoMySql.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
