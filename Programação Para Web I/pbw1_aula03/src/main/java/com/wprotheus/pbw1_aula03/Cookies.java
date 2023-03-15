package com.wprotheus.pbw1_aula03;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookies", value = "/cookies")
public class Cookies extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try (PrintWriter out = response.getWriter())
		{
			Cookie[] cks = request.getCookies();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Pbw1 - Aula 03</title>");
			out.println("<style>h3 {color:darkblue; font-size: x-large; margin-left: 2em;}");
			out.println("h1 {color:navy;text-align: center;}");
			out.println("#info {color: black; font-weight: bolder; font-size: x-large; </style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Aula 03 - Cookies</h1><hr>");
			for (Cookie c : cks)
				out.println("<h3>Ganhou 25% de descontos no seguinte produto: " + c.getValue() + "</h3>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
