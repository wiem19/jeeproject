<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">  
    <title>Page1</title>  
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">  
</head>
<body>


<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">          
            <a class="navbar-brand" href="#">E-Boutique ENIG</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="">Home</a></li>
                <li><a href='#'>Promotions</a></li>
                <li><a href='#'>Ventes Flash</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">                
                <li><a href="#"> Mon Panier() </a>   </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">

    <div class="row" style="margin-top: 80px;">
           <div class="col-md-6">
           <form method="post" action="Verification">
username<input type="text" name="login">
Password<input type="password" name="password">
connecter<input type="submit" value="submit">
</form>
        </div>
      


        <div class="col-md-6">
        <form method="post" action=Ajouter>
Nom<input type="text" name="nom">
Prenom<input type="text" name="prenom">
username<input type="text" name="username">
Password<input type="password" name="password">
Email<input type="text" name="email">

connecter<input type="submit" value="submit">
</form>
        </div>
    </div>


</div>


</body>
</html>
