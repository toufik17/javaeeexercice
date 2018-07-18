<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Saisie</title>
</head>
<body>
<table border="1" cellpadding="3" cellspacing="2" width="90%"
		align="center">
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Civilité</b></b></td>
			<td>${stagiaire.civilite}</td>
		</tr>
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Nom</b></b></td>
			<td>${stagiaire.nom}</td>
		</tr>
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Prénom</b></td>
			<td>${stagiaire.prenom}</td>
		</tr>
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Date de naissance</b></td>
			<td>${stagiaire.dateNaissance}</td>
		</tr>
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Adresse mail</b></td>
			<td>${stagiaire.email}</td>
		</tr>
		
	</table>
</body>
</html>