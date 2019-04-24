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
        </tr>
        <c:set  value="${Player}" var ="player" scope="page"></c:set>
        <tr>
          <td>${player.id}</td>
          <td>${player.name}</td>
          <td>${player.nationality}</td>
          <td>${player.club}</td>
        </tr>
        
      </table>
    </div>
       
   </body>
   
</html>