<!doctype html>

<html lang="pl">
<head>
<property name="hibernate.connection.useUnicode">true</property> 
<property name="hibernate.connection.characterEncoding">UTF-8</property> 
<meta charset="utf-8">

<title>Homepage</title>
<meta name="description" content="I downloaded this template from somewhere">
<meta name="author" content="SitePoint">

<link rel="stylesheet" href="css/styles.css?v=1.0">

</head>
<body>
	<form action="http://localhost:8080/JdbcCrud/OperationStatus"
		method="POST">
		Tytuł: <input type="TEXT" name="title"><br> 
		Treść: <input type="TEXT" name="text"><br> 
		<input type="SUBMIT" value="Wyslij">
	</form>
</body>
</html>