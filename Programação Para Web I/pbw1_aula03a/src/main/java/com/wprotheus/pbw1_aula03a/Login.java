package com.wprotheus.pbw1_aula03a;

import java.util.ArrayList;

public class Login
{
	private String user, pass;
	Boolean logado=false;

	public Login(){}

	public Login(String user, String pass, Boolean logado)
	{
		this.user = user;
		this.pass = pass;
		this.logado = false;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public Boolean getLogado()
	{
		return logado;
	}

	public void setLogado(Boolean logado)
	{
		this.logado = logado;
	}
}
