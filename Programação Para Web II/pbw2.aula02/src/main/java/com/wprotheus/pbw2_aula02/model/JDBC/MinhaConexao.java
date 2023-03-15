package com.wprotheus.pbw2_aula02.model.JDBC;

import java.sql.Connection;

public class MinhaConexao
{
	public static Connection conexao()
	{
		ConexaoJDBC conexao = new ConexaoMySql();
		return conexao.criarConexao();
	}
}
