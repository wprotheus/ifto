package com.wprotheus.pbw1trabalho01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Resultado", value = "/resultado")
public class Resultado extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String nomeAluno = request.getParameter("nome");
		String[] mamiferos = request.getParameterValues("mamiferos");
		String[] softwares = request.getParameterValues("software");
		String dataww1 = request.getParameter("ww1");
		String metal = request.getParameter("metal");
		Integer expressao = Integer.parseInt(request.getParameter("expressao"));
		Float notamam = 1.25f;
		Float notasoft = 0.8f;
		Float notadata = 0f;
		Float notametal = 0f;
		Float notaexpr = 0f;
		Float notafinal = 0f;


		try (PrintWriter out = response.getWriter())
		{
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Pbw1 - Trabalho 01</title>");
			out.println("<style>h3 {color:darkblue; font-size: x-large; margin-left: 2em;}");
			out.println("h1 {color:navy;text-align: center;}");
			out.println("#info {color: black; font-weight: bolder; font-size: x-large; </style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Resultado</h1><hr>");
			out.println("<p id=\"info\">Nome do Aluno: " + nomeAluno + "</p><hr>");
			for(String mammals:mamiferos)
			{
				if (mammals.equals("Tubarão"))
					notamam -= 0.25f;
				if (mammals.equals("Golfinho"))
					notamam += 0.25f;
				if (mammals.equals("Tartaruga"))
					notamam -= 0.25f;
				if (mammals.equals("Onça"))
					notamam += 0.25f;
				if (mammals.equals("Sapo"))
					notamam -= 0.25f;
				if (mammals.equals("Largato"))
					notamam -= 0.25f;
				if (mammals.equals("Mico Leão"))
					notamam += 0.25f;
				if (mammals.equals("Garça"))
					notamam -= 0.25f;
			}

			for(String softs:softwares)
			{
				if (softs.equals("so"))
					notasoft += 0.4f;
				if (softs.equals("ram"))
					notasoft -= 0.4f;
				if (softs.equals("gpu"))
					notasoft -= 0.4f;
				if (softs.equals("planilha"))
					notasoft += 0.4f;
				if (softs.equals("compilador"))
					notasoft += 0.4f;
			}

			if (dataww1.equals("1914-07-28"))
				notadata=2.0f;

			if (metal.equals("mercurio"))
				notametal=2.0f;

			int expr = 2 + (4*5) -3;
			if (expressao == expr)
				notaexpr=2.0f;

			notafinal = (notamam+ notasoft+ notadata+ notametal+notaexpr);
			if (notafinal>6)
				out.println("<p id=\"info\">Parabéns, você foi aprovado. Sua nota final é: " + notafinal + "</p>");
			else
				out.println("<p id=\"info\">Você foi reprovado. Sua nota final é: " + notafinal + "</p><hr>");
			out.println("</body>");
			out.println("</html>");
		}

	}
}