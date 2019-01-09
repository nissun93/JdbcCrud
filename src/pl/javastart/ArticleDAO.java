package pl.javastart;

import java.sql.*;

public class ArticleDAO {

	/**
	 * Tutaj nale¿y zdefiniowaæ u¿ytkownika, has³o, adres oraz
	 * sterownik do bazy danych z któr¹ zamierzamy siê po³¹czyæ.
	 */
	private final static String DBURL = "jdbc:mysql://localhost/blog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final static String DBUSER = "root";
	private final static String DBPASS = "****";
	private final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";

	//obiekt tworz¹cy po³¹czenie z baz¹ danych.
	private Connection connection;
	//obiekt pozwalaj¹cy tworzyæ nowe wyra¿enia SQL
	private Statement statement;
	//zapytanie SQL
	private String query;
	//parser zapytañ SQL dla obiektów klasy Article
	private SQLArticleParser sqlArticleParser;

	public ArticleDAO() {
		//inicjalizacja parserów
		sqlArticleParser = new SQLArticleParser();
	}

	public boolean save(Article article) {
		query = sqlArticleParser.createSaveQuery(article);

		try {
			Class.forName(DBDRIVER).newInstance();
			connection = DriverManager.getConnection(DBURL,DBUSER,"");
			statement = connection.createStatement();
			statement.executeUpdate(query);

                        //zwolnienie zasobów i zamkniêcie po³¹czenia
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
