<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rechercher</title>
</head>
<body>
<c:import url="/Resources/navigation.jsp"/>

<h1>RECHERCHER DANS CONTACTES</h1>

	<form action="Controleur" method="post" class="contact">
		
		
		<label for="nom">NOM</label> 
		<input type="text" name="nom" id="nom" value="${nomRequest }" /> 
		<label for="prenom">PRENOM</label>
		<input type="text" name="prenom" id="prenom" value="${prenomRequest }" /> 
		<label for="telephone">TELEPHONE</label>
		<input type="text" name="telephone" id="telephone" value="${telephoneRequest }" /> 
		<label for="mail">E-MAIL</label> 
		<input type="text" name="mail" id="mail" value="${mailRequest}" />
		<label for="adresse">ADRESSE</label> 
		<input type="text" name="adresse" id="adresse" value="${adresseRequest }" />

		<input type="hidden" name="requestUser" id="requestUser" value="RechercherContact" />
		<input type="submit" value="RECHERCHER" class="submit"/>
		
	</form>
	
	<!-- liste des contacts -->
	
	<c:choose>
		<c:when test="${trouve && recherche }">
	
	<h1>RESULTATS</h1>
			<table>
		
		<tr class="header">
		
			<th>N°</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Téléphone</th>
			<th>E-Mail</th>
			<th>Adresse</th>
			<th>Actions</th>
			
		</tr>
		<c:forEach items="${contacts}" var="contact" varStatus="status">
			<tr>
			
				<td><c:out value="${status.count }" /></td>
				<td><c:out value="${contact.nom }" /></td>
				<td><c:out value="${contact.prenom }" /></td>
				<td><c:out value="${contact.telephone }" /></td>
				<td><c:out value="${contact.mail }" /></td>
				<td><c:out value="${contact.adresse }" /></td>
				
				<td>
				
				<div >
					<form action="Controleur" method="post" class="actions">

						<input type="hidden" name="requestUser" id="requestUser" value="SupprimerContact" />
						<input type="hidden"name="identifiant" id="identifiant" value="${contact.identifiant}" /> 
						<input type="submit" value="SUPPRIMER" class="afficher"/>			
						

					</form>
					
					<form action="Controleur" method="post" class="actions">
					
						<input type="hidden" name="nom" id="nom" value="${contact.nom}" />
						<input type="hidden" name="prenom" id="prenom" value="${contact.prenom}" />
						<input type="hidden" name="telephone" id="telephone" value="${contact.telephone}" />
						<input type="hidden" name="adresse" id="adresse" value="${contact.adresse}" />
						<input type="hidden" name="mail" id="mail" value="${contact.mail}" />
						<input type="hidden" name="requestUser" id="requestUser" value="ModifierContactJSP" />
						<input type="hidden" name="identifiant" id="identifiant" value="${contact.identifiant}" />
						<input type="submit" value="MODIFIER" class="afficher"/>
						 

					</form>
				</div>
				</td>
			</tr>
		</c:forEach>
	</table>
		</c:when>
		<c:when test="${!trouve && recherche }">
			<h1 style="color:red;">Pas de résultat</h1>
		</c:when>
	</c:choose>

<footer>
		<div class="footer-container"> 
				<p>© Copyright 2022 - All rights reserved.</p>
				<p>© By Student of Reunion Island University.</p>
		</div>
</footer>

</body>
</html>