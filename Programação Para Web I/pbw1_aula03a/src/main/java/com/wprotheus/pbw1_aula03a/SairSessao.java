package com.wprotheus.pbw1_aula03a;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SairSessao", value = "/sair")
public class SairSessao extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(false);
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
			if (session != null)
			{
				String logado = (String) session.getAttribute("logado");
				session.invalidate();
				out.print("<h3>" + logado + ", você saiu da sessão com sucesso!</h3><br><hr>");
			} else out.println("<h1>Não estava logado.</h1><hr>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
}
