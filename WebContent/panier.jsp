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
                <li><a href='Login.jsp'>SignUp</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">                
                <li><a href="AfficherPanier"> Mon Panier(${panier.listpanier.size()}) </a>   </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">

    <div class="row" style="margin-top: 80px;">
           <div class="col-md-3">
            <div class="list-group">
                <a href="Boutique" class="list-group-item active"> Tous les Produits </a>
                	 <c:forEach var="lv" items="${categorie}">
                <a href="RechercheProduit?cat=${lv.id}" class="list-group-item">${lv.description}</a>
                		 </c:forEach>
            </div>
        </div>
      


        <div class="col-md-9">
            <div class="panel panel-info">
                <div class="panel-heading">Mon panier </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
							<tr> 
							
							<th>#</th>
							
								<th>D&eacute;signation de vos articles</th>
								<th>Prix UT</th>
								<th>Quantit&eacute;</th>
								<th>Total</th>
								<th></th>
								
							</tr>
                        </thead>
                        <tbody>
                                <c:forEach var="lv" items="${panier.listpanier}">
							<tr>
							
								<th scope="row">${lv.quantite}</th>
								<td>
									<img src="images/${lv.p.id}.jpg" width="10%"> ${lv.p.description}
								</td>
								<td>${lv.p.prix}</td>
								<td>${lv.quantite}</td>
								<td>${lv.p.prix * lv.quantite}</td>
								<td><a class="btn btn-danger " href="SupprimerPanier?id=${lv.p.id}">Suppimer </a></td>
							</tr>
							 </c:forEach>
                        </tbody>						
                    </table>

                </div>
                                
            </div>
            <a class="btn btn-danger " href="ViderPanier">vider le Panier </a>
            
              <a class="btn btn-success " href="CommandeS">Poursuivre </a>
                
        </div>
    </div>


</div>


</body>
</html>
