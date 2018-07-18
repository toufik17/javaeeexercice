<html>
<head>

<title>Erreur</title>

</head>
<body>

	<%@ page import="idp.exerciceservlet.entite.*"%>

	<h3 align="center">Confirmation de votre demande d'inscription</h3>

	<p>
	<table border="1" cellpadding="3" cellspacing="2" width="90%"
		align="center">
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Nom</b></b></td>
			<td>${stagiaire.nom}</td>
		</tr>
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Prénom</b></td>
			<td>${stagiaire.prenom}</td>
		</tr>
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Adresse mail</b></td>
			<td>${stagiaire.email}</td>
		</tr>
	</table>
	</p>
	<h3 align="center">
		<font color="red">Attention : stagiaire déjà enregistré</font>
	</h3>
</body>
</html>
