<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delete vehicle</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddVehicle">add vehicle</a> | 
<a href="EditVehicle">edit vehicle</a> | 
<a href="DeleteVehicle">delete vehicle</a> |
	<form action="DeleteVehicle" method="post">
	
		</label> <label> delete vehicle with id: <input type="number" name="id" required/>
		</label> <br>  <input type="submit" value="Wyślij" required/>

	</form>
	<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>