package pl.javastart;

public class SQLArticleParser {

	//Metoda tworz�ca zapytanie SQL zapisuj�ce artykul do bazy
	public String createSaveQuery(Article article) {
		String query = "";

		/**
		 * Dodaj do tabeli "articles" warto�ci id, title i text.
		 * id jest nullem, poniewa� pole id jest autoinkrementowane
		 * przez baz� danych.
		 * INSERT INTO articles VALUES (NULL, 'title', 'text');
		 */	
		query = "INSERT INTO articles VALUES (NULL, '" + article.getTitle() + "', '" + article.getText() +"');";

		return query;
	}
}