package com.wprotheus.pbw2_aula02.model.entity;

import jakarta.persistence.*;

//@Entity //@Entity annotation indicates that the class is a persistent Java class.
//@Table(name="tb_pessoa")
public class Pessoa
{
	//@Id //@Id annotation is for the primary key.
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(nullable = false, columnDefinition = "BIGINT DEFAULT 0000")
	private Long id;
	//@Column(nullable = false, length = 44)
	private String nome;

	public Pessoa() { }

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		return sb.append("ID: ").append(this.id)
				.append(" - ").append("Nome: ").append(this.nome).toString();
	}
}