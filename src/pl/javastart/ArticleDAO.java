package pl.javastart;

import java.sql.*;

public class ArticleDAO {

	/**
	 * Tutaj nale�y zdefiniowa� u�ytkownika, has�o, adres oraz
	 * sterownik do bazy danych z kt�r� zamierzamy si� po��czy�.
	 */
	private final static String DBURL = "jdbc:mysql://localhost/blog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final static String DBUSER = "root";
	private final static String DBPASS = "****";
	private final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";

	//obiekt tworz�cy po��czenie z baz� danych.
	private Connection connection;
	//obiekt pozwalaj�cy tworzy� nowe wyra�enia SQL
	private Statement statement;
	//zapytanie SQL
	private String query;
	//parser zapyta� SQL dla obiekt�w klasy Article
	private SQLArticleParser sqlArticleParser;

	public ArticleDAO() {
		//inicjalizacja parser�w
		sqlArticleParser = new SQLArticleParser();
	}

	public boolean save(Article article) {
		query = sqlArticleParser.createSaveQuery(article);

		try {
			Class.forName(DBDRIVER).newInstance();
			connection = DriverManager.getConnection(DBURL,DBUSER,"");
			statement = connection.createStatement();
			statement.executeUpdate(query);

                        //zwolnienie zasob�w i zamkni�cie po��czenia
                        statement.close();
                        connection.close();
                        
                        return true;
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.toString();
			e.printStackTrace();
			return false;
		}
	}
}
