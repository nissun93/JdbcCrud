package pl.javastart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OperationStatus
 */
@WebServlet("/OperationStatus")
public class OperationStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Parser, kt�ry ma za zadanie przetwarzanie
	 * �r�d�a posiadaj�cego artyku�. �r�d�em mo�e 
	 * by� np HttpRequest
	 */
	//private ArticleParser articleParser;

	/**
	 * DAO - typ klasy odpowiadaj�cy za po��czenie
	 * aplikacji ze �r�d�em danych, np. baz� danych.
	 * To tutaj b�dzie znajdowa� si� implementacja
	 * JDBC.
	 */
	private ArticleDAO articleDAO;

	//inicjalizacja komponent�w
	public OperationStatus() {
		//articleParser = new ArticleParser();
		articleDAO = new ArticleDAO();
	}

	//pobieranie artyku�u z http POST
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)	throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		
		//Wykorzystaj parser do artyku��w i pobierz artyku� z requesta
		Article article = new Article();
		article.setTitle(request.getParameter("title"));
		article.setText(request.getParameter("text"));

		//zapisz artyku� do bazy danych
		if(articleDAO.save(article)){
			pw.println("Article added succesfully!");
			pw.println("<a href=\"\">Home</a>");
		}
		
	}
}
