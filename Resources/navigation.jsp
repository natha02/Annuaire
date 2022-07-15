<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&family=Work+Sans:wght@300&display=swap" rel="stylesheet">
<link href="Resources/navigation.css" rel="stylesheet">
<link href="Resources/contact.css" rel="stylesheet"/>
<link href="Resources/afficher.css" rel="stylesheet"/>

<title></title>
</head>
<body>
<header>
		<h1 class="title">PROGRAMMATION WEB SERVER - <br/>  PROJET ANNUAIRE </h1>
		<p class="student">KALAHA Andrilalaina</p>
</header>
<div class="navigation">

	<form action="Controleur" method="post" class="container">
		<input type="hidden" name="requestUser" id="requestUser" value="IndexJSP" />
		<input type="submit" value="HOME" class="button"/>
	</form>
	
	<form action="Controleur" method="post" class="container">
		<input type="hidden" name="requestUser" id="requestUser" value="CreerContactJSP" />
		<input type="submit" value="CREER" class="button"/>
	</form>
	
	<form action="Controleur" method="post" class="container">
		<input type="hidden" name="requestUser" id="requestUser" value="RechercherContactJSP" />
		<input type="submit" value="RECHERCHER" class="button"/>
	</form>
	
	<form action="Controleur" method="post" class=container>
		<input type="hidden" name="requestUser" id="requestUser" value="AfficherContactJSP" />
		<input type="submit" value="AFFICHER" class="button"/>
	</form>
	
</div>

</body>
</html>