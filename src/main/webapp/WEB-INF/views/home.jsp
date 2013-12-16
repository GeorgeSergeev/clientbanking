<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<html>
<%@include file="includes/header.jsp" %> 

<body>
	<div class="container">		
	<%@include file="includes/top.jsp" %>
	<article>
	 <p>Welcome <span id="username"><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>!</p> 
	 <div class="row">
        <div class="col-md-6">
          <h2>Accounts list</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-6">
          <h2>Transactions</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
       </div>        
     </div>
	 </article>
	</div>
	<%@include file="includes/footer.jsp" %>
</body>
</html>