<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add customer</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddCustomer">add customer</a> | 
<a href="EditCustomer">edit customer</a> | 
<a href="DeleteCustomer">delete customer</a> |
	<form action="AddCustomer" method="post">

		<label> name: <input type="text" name="name" />
		</label> <label> surname: <input type="text" name="surname" />
		</label> <label> Date of birth: <input type="date" name="birthDate" />
		</label> <br>  <input type="submit" value="Wyślij" />

	</form>
	<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>