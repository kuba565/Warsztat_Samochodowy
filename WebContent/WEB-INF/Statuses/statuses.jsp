<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>

<%@ page import="java.util.Date"%>
<%@ page import="pl.coderslab.dao.Status"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Status</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
	|
	<a href="AddStatus">add status</a> |
	<a href="EditStatus">edit status</a> |
	<a href="DeleteStatus">delete status</a> |
	<table>
		<tr>
			<th>id</th>
			<th>Status</th>
		</tr>
		<%
			ArrayList<Status> statuses = (ArrayList<Status>) request.getAttribute("statuses");

			if (statuses != null) {
				for (Status status : statuses) {
					String currStatus = status.getStatus();
					int currId = status.getId();
		%>

		<tr>
			<td><%=currId%></td>
			<td><%=currStatus%></td>
		</tr>

		<%
			}
			}
		%>

	</table>
<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>