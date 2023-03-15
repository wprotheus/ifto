package com.wprotheus.pbw2_aula02.controller.pessoaController;

import com.wprotheus.pbw2_aula02.model.DAO.PessoaDAO;
import com.wprotheus.pbw2_aula02.model.entity.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pessoas")
public class PessoaController
{
	PessoaDAO pessoaDAO;

	public PessoaController()
	{
		pessoaDAO = new PessoaDAO();
	}

	@GetMapping("/form")
	public String form(Pessoa pessoa)
	{
		return "/pessoa/form";
	}
	@GetMapping("/lista")
	public ModelAndView lista(@RequestParam("idpesq") Long idpesq, ModelMap model)
	{
		model.addAttribute("idpesq", idpesq);
		model.addAttribute("pessoas", pessoaDAO.buscarPessoa(idpesq));
		return new ModelAndView("/pessoa/list", model);
	}

	@GetMapping("/list")
	public ModelAndView listar(ModelMap model)
	{
		model.addAttribute("pessoas", pessoaDAO.buscarPessoas());
		return new ModelAndView("/pessoa/list", model);
	}

	@PostMapping("/save")
	public String save(Pessoa pessoa)
	{
		pessoaDAO.save(pessoa);return "redirect:/pessoas/list";

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
		return new ModelAndView("/pessoa/form", model);
	}

	@PostMapping("/update")
	public ModelAndView update(Pessoa pessoa)
	{
		pessoaDAO.update(pessoa);
		return new ModelAndView("redirect:/pessoas/list");
	}
}