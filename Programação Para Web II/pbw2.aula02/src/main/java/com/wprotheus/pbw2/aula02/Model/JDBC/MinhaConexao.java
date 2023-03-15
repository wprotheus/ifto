package com.wprotheus.pbw2.aula02.Model.JDBC;

import java.sql.Connection;

public class MinhaConexao
{
	public static Connection conexao()
	{
		ConexaoJDBC conexao = new ConexaoMysql();
		return conexao.criarConexao();
	}
}