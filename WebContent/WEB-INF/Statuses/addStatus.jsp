<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add status</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddStatus">add status</a> | 
<a href="EditStatus">edit status</a> | 
<a href="DeleteStatus">delete status</a> |

<form action="AddStatus" method="post">
  <input type="radio" name="status" value="przyjety" checked> Przyjęty<br>
  <input type="radio" name="status" value="zatwierdzone koszty"> Zatwierdzone koszty naprawy<br>
  <input type="radio" name="status" value="w naprawie"> W naprawie<br>
  <input type="radio" name="status" value="gotowy do odbioru"> Gotowy do odbioru<br>
  <input type="radio" name="status" value="rezygnacja"> Rezygnacja<br>
  
<input type="submit" value="Wyślij" />
</form>
	<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>