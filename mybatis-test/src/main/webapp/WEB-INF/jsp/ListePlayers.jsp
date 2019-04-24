<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
   <head>
        <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
   </head>
   <body>
      <h1>Liste des joueurs</h1>
       
      <br/><br/>
    <div class ="table">
      <table border="1">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Nationality</th>
          <th>Club</th>
          <th>Option1</th>
          <th>Option2</th>
        </tr>
        <c:forEach  items="${Players}" var ="player">
        <tr>
          <td>${player.id}</td>
          <td>${player.name}</td>
          <td>${player.nationality}</td>
          <td>${player.club}</td>
          <td>
          <a href = "${pageContext.request.contextPath }/players/delete/${player.id }" onclick="return confirm('Etes-vous sûr?')">Supprimer</a></td>
          <td>
          <a href = "${pageContext.request.contextPath }/players/update/${player.id}">Mettre à jour</a></td>
        </tr>
        </c:forEach>
      </table>
    </div>
    <form action="${pageContext.request.contextPath }/players/insert"><input type="submit" value="Ajouter un joueur" class ="btn btn-lg btn-primary" /></form>
       
   </body>
   
</html>