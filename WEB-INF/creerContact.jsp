<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>creer contact</title>
</head>
<body>
<c:import url="/Resources/navigation.jsp"/>

	<h1>CREATIONS DES CONTACTES</h1>

<form action="Controleur" method="post" class="contact">

	<label for="nom">NOM </label>
	<input type="text" name="nom" id="nom" required="required"/>	
	<label for="prenom">PRENOM  </label>
	<input type="text" name="prenom" id="prenom" required="required"/>
	<label for="telephone">TELEPHONE  </label>
	<input type="text" name="telephone" id="telephone" required="required"/>
	<label for="mail">E-MAIL </label>
	<input type="text" name="mail" id="mail" required="required"/>
	<label for="adresse">ADRESSE </label>
	<input type="text" name="adresse" id="adresse"/>
	<input type="hidden" name="requestUser" id="requestUser" value="CreerContact" />
	<input type="submit" value="CREER CONTACT" class="submit"/>
	
</form>

<footer>
		<div class="footer-container"> 
				<p>© Copyright 2022 - All rights reserved.</p>
				<p>© By Student of Reunion Island University.</p>
		</div>
</footer>
</body>
</html>