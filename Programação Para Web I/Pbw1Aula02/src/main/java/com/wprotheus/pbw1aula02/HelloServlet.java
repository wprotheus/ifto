package com.wprotheus.pbw1aula02;

import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/helloservlet")
public class HelloServlet extends HttpServlet
{

	private String message;

	public void init()
	{

		message = "Hello World!";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{

		response.setContentType("text/html; charset=UTF-8");
		String[] produtos = request.getParameterValues("produtos");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for (String produto : produtos)
		{
			out.println("<h1>" + produto + "</h1>");
		}
		out.println("<hr><ul>");
		Enumeration<String> chaves = request.getParameterNames();
		while (chaves.hasMoreElements())
		{
			String chave = chaves.nextElement();
			out.println("<li>" + chave + " = " + request.getParameter(chave) + "</li>");

		}
		out.println("<hr></ul>");
		out.println("</body></html>");
	}

	public void destroy()
	{

	}
}