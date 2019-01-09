package pl.javastart;

public class SQLArticleParser {

	//Metoda tworz¹ca zapytanie SQL zapisuj¹ce artykul do bazy
	public String createSaveQuery(Article article) {
		String query = "";

		/**
		 * Dodaj do tabeli "articles" wartoœci id, title i text.
		 * id jest nullem, poniewa¿ pole id jest autoinkrementowane
		 * przez bazê danych.
		 * INSERT INTO articles VALUES (NULL, 'title', 'text');
		 */	
		query = "INSERT INTO articles VALUES (NULL, '" + article.getTitle() + "', '" + article.getText() +"');";

		return query;
	}
}