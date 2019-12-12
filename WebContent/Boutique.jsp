<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="bootstrap/css/bootstrap.min.css"  rel="stylesheet" >
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
        
		 <c:forEach var="lv" items="${produit}">
		 
            <div class="col-md-4">
                <div class="thumbnail">
                    <img src="images/${lv.id.toString()}.jpg" >
                    <div class="caption">
                        <h3>${lv.description}</h3>
                        <p><a href="AjouterPanier?id=${lv.id.toString()}" class="btn btn-primary" >Ajouter Panier</a>
                            <a href="#" class="btn btn-danger" >${lv.prix.toString()}</a>
                        </p>
                    </div>
                </div>
            </div>   
           </c:forEach>
          
        </div>

    </div>

</div>


</body>
</html>