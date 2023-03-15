package com.wprotheus.pbw1_aula03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "Cookies", value = "/cookies")
@WebServlet(name = "Condicionador", value = "/condicionador")
public class Condicionador extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try (PrintWriter out = response.getWriter())
		{
			Cookie ck = new Cookie("produto", "condicionador");
			ck.setMaxAge(3600 * 24);
			response.addCookie(ck);
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
			out.println("<h3>Condicionador</h3>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
