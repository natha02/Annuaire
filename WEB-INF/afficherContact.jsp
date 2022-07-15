<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:import url="/Resources/navigation.jsp"/>

<h1>LISTE DES CONTACTES</h1>


<table>


	<tr class="header">
	
			<th>N°</th>
			<th>NOM</th>
			<th>PRENOM</th>
			<th>TELEPHONE</th>
			<th>E-MAIL</th>
			<th>ADRESSE</th>
			<th>ACTIONS</th>
			
	</tr>
	
		<c:forEach items="${annuaire.contacts}" var="contact" varStatus="status">
			<tr>
				<%-- on récupère nos valeur utile et on les mets dans un tableau --%>
				<td><c:out value="${status.count }" /></td>
				<td><c:out value="${contact.nom }" /></td>
				<td><c:out value="${contact.prenom }" /></td>
				<td><c:out value="${contact.telephone }" /></td>
				<td><c:out value="${contact.mail }" /></td>
				<td><c:out value="${contact.adresse }" /></td>
				
				<td>
				<div >
				<%-- vu que c'est un formulaire c'est mieux d'utiliser la method post --%>
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


<footer>
		<div class="footer-container"> 
				<p>© Copyright 2022 - All rights reserved.</p>
				<p>© By Student of Reunion Island University.</p>
		</div>
</footer>

</body>
</html>