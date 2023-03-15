package com.wprotheus.pbw1_aula03a;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Perfil", value = "/perfil")
public class Perfil extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(false);
		String logado = (String) session.getAttribute("logado");
		try (PrintWriter out = response.getWriter())
		{
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Pbw1 - Sessão</title>");
			out.println("<style>h3 {color:darkblue; font-size: x-large; margin-left: 2em;}");
			out.println("h1 {color:navy;text-align: center;}");
			out.println("#info {color: black; font-weight: bolder; font-size: x-large; </style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Perfil do usuário...</h1><br><hr>");
			out.print("<h3>O usuário logado é: <b>" + logado + "!</b></h3><br><hr>");
			out.println("<a href=\"sair\">Sair</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
}
