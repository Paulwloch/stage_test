<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
   <head>
        <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
   </head>
   <body>
      <h1>Ajout d'un joueur</h1>
       
      <br/><br/>
    
    <form:form modelAttribute= "joueur" cssClass ="form-horizontal">
  <div class="form-group">
    <label for="name" class="col-sm-2 col-form-label">Nom</label>
    <div class="col-sm-10">
      <form:input path = "name" cssClass= "form-control"/>
    </div>
    </div>
    
    <div class="form-group">
    <label for="nationality" class="col-sm-2 col-form-label">Nationalité</label>
    <div class="col-sm-10">
      <form:input path = "nationality" cssClass= "form-control"/>
    </div>
      </div> 
       <div class="form-group">
    <label for="club" class="col-sm-2 col-form-label">Club</label>
    <div class="col-sm-10">
      <form:input path = "club" cssClass= "form-control"/>
    </div>
    </div>
      <div class="form-group">
      	<div class="col-sm-2">
      	<input type="submit" value ="Ajouter" class ="btn btn-lg btn-primary"/>
      	</div>
      	</div>
    
    </form:form>
   </body>
   
</html>