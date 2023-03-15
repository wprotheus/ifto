package com.wprotheus.pbw1_aula03a;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CriarSessao", value = "/criar")
public class CriarSessao extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		Login user1 = new Login("José", "1234", false);
		Login user2 = new Login("Maria", "abcd", false);
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
			out.println("<h1>Logando...</h1><br><hr>");
			if (session != null)
			{
				String usuario = request.getParameter("user");
				String senha = request.getParameter("pass");
				if (user1.getUser().equals(usuario) && user1.getPass().equals(senha) || user2.getUser().equals(usuario) && user2.getPass().equals(senha))
				{
					session.setAttribute("logado", usuario);
					out.print("<h3>" + usuario + ", você está logado(a) com sucesso!</h3><br><hr>");
				}
				else
					out.print("<h3>Não foi possível logar no sistema!</h3><br><hr>");
			}
//			out.println("<form method=\"post\" action=\"perfil\">\n");
//			out.println("<input type=\"submit\" value=\"Perfil\">\n");
//			out.println("</form>\n");
			out.println("<a href=\"perfil\">Perfil</a><br>");
			out.println("<a href=\"sair\">Sair</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}