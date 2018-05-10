<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add vehicle</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddVehicle">add vehicle</a> | 
<a href="EditVehicle">edit vehicle</a> | 
<a href="DeleteVehicle">delete vehicle</a> |
	<form action="AddVehicle" method="post">

		<label> Make: <input type="text" name="make" />
		</label> <label> Model: <input type="text" name="model" />
		</label> <label> Next review <input type="date" name="nextReview" />
		</label> <label> Reg number <input type="text" name="regNumber" />
		</label> <label> Year of production <input type="date" name="yearOfProduction" />
		</label> <br>  <input type="submit" value="Wyślij" />

	</form>
	<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>