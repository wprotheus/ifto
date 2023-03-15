package com.wprotheus.pbw2.aula02.Controller;

import com.wprotheus.pbw2.aula02.Model.Entity.Pessoa;
import com.wprotheus.pbw2.aula02.DAO.PessoaDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pessoas")
public class PessoasController
{
	PessoaDAO pessoaDAO;

	public PessoasController()
	{
		pessoaDAO = new PessoaDAO();
	}

	@GetMapping("/form")
	public String form(Pessoa pessoa)
	{
		return "/pessoas/form";
	}

	@GetMapping("/list")
	public String list(ModelMap model)
	{
		model.addAttribute("pessoas", pessoaDAO.buscarPessoas());
		return "/pessoas/list";
	}

	@PostMapping("/save")
	public ModelAndView save(Pessoa pessoa)
	{
		pessoaDAO.save(pessoa);
		return new ModelAndView("redirect:/pessoas/list");
	}

	@GetMapping("/remove/{id}")
	public ModelAndView remove(@PathVariable("id") Long id)
	{
		pessoaDAO.remove(id);
		return new ModelAndView("redirect:/pessoas/list");
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id, ModelMap model)
	{
		model.addAttribute("pessoa", pessoaDAO.buscarPessoa(id));
		return new ModelAndView("/pessoas/form", model);
	}

	@PostMapping("/update")
	public ModelAndView update(Pessoa pessoa)
	{
		pessoaDAO.update(pessoa);
		return new ModelAndView("redirect:/pessoas/list");
	}
}