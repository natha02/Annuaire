<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:import url="/Resources/navigation.jsp"/>

					<h1>CHOISIR LE/LES CHAMPS À MODIFIER</h1>
			
	<form action="Controleur" method="post" class="contact">
					
					<label for="nom">NOM </label>
					<input type="text" name="nom" id="nom" value="${param.nom}" required="required"> 
					<label for="prenom">PRENOM </label>
					<input type="text" name="prenom" id="prenom" value="${param.prenom}" required="required"/> 					
					<label for="telephone">TELEPHONE</label>
					<input type="text" name="telephone" id="telephone" value="${param.telephone}" required="required"/> 					
					<label for="mail">E-MAIL</label> 
					<input type="text" name="mail" id="mail" value="${param.mail}" required="required"/>					
					<label for="adresse">ADRESSE</label> 
					<input type="text" name="adresse" id="adresse" value="${param.adresse }"/> 
					
					<input type="hidden" name="requestUser" id="requestUser" value="ModifierContact" />
					<input type="hidden" name="identifiant" id="identifiant" value="${param.identifiant}"/>				
					<input type="submit" value="MODIFIER" class="submit"/>
							
	</form>
		
		<footer>
		<div class="footer-container"> 
				<p>© Copyright 2022 - All rights reserved.</p>
				<p>© By Student of Reunion University.</p>
		</div>
</footer>	
			
</body>
</html>