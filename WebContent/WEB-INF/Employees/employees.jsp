<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>

<%@ page import="pl.coderslab.dao.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddEmployee">add employee</a> | 
<a href="EditEmployee">edit employee</a> | 
<a href="DeleteEmployee">delete employee</a> |

	<table>
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Note</th>
			<th>Cost of work hour</th>
		</tr>
		<%
			ArrayList<Employee> employees = (ArrayList<Employee>) request.getAttribute("employees");
		
			if (employees != null) {
				for (Employee employee : employees) {
					String currName = employee.getName();
					String currSur = employee.getSurname();
					String currAddress = employee.getAddress();
					String currPhone = employee.getPhone();
					String currNote = employee.getNote();
					Double currWrkCost = employee.getWrkHourCost();
					int currId = employee.getId();
		%>

		<tr>
			<td><%=currId%></td>
			<td><%=currName%></td>
			<td><%=currSur%></td>
			<td><%=currAddress%></td>
			<td><%=currPhone%></td>
			<td><%=currNote%></td>
			<td><%=currWrkCost%></td>
		</tr>

		<%
			}
			}
		%>

	</table>
	
<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>