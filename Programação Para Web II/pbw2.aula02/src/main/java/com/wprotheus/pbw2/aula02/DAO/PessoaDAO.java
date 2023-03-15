package com.wprotheus.pbw2.aula02.DAO;

import com.wprotheus.pbw2.aula02.Model.Entity.Pessoa;
import com.wprotheus.pbw2.aula02.Model.JDBC.MinhaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO
{
	Connection con;

	public PessoaDAO()
	{
		con = MinhaConexao.conexao();
	}

	public List<Pessoa> buscarPessoas()
	{
		try
		{
			String sql = "select * from tb_pessoa";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Pessoa> pessoas = new ArrayList();

			while (rs.next())
			{
				Pessoa p = new Pessoa();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				pessoas.add(p);
			}
			return pessoas;
		} catch (SQLException ex)
		{
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public boolean remove(Long id)
	{
		try
		{
			String sql = "delete from tb_pessoa where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			if (ps.executeUpdate() == 1) return true;
		} catch (SQLException ex)
		{
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public boolean save(Pessoa pessoa)
	{
		try
		{
			String sql = "insert into tb_pessoa (nome) values (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			if (ps.executeUpdate() == 1) return true;
		} catch (SQLException ex)
		{
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public boolean update(Pessoa pessoa)
	{
		try
		{
			String sql = "update tb_pessoa set nome=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setLong(2, pessoa.getId());
			if (ps.executeUpdate() == 1) return true;
		} catch (SQLException ex)
		{
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public Pessoa buscarPessoa(Long id)
	{
		try
		{
			String sql = "select * from tb_pessoa where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				Pessoa p = new Pessoa();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				return p;
			}
		} catch (SQLException ex)
		{
			Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}