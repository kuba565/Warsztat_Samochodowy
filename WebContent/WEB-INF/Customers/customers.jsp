<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>

<%@ page import="pl.coderslab.dao.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customers</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddCustomer">add customer</a> | 
<a href="EditCustomer">edit customer</a> | 
<a href="DeleteCustomer">delete customer</a> |

	<table>
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Date of birth</th>
		</tr>
		<%
			ArrayList<Customer> customers = (ArrayList<Customer>) request.getAttribute("customers");
		
			if (customers != null) {
				for (Customer customer : customers) {
					String currName = customer.getName();
					String currSur = customer.getSurname();
					String currDate = customer.getBirthDate();
					int currId = customer.getId();
		%>

		<tr>
			<td><%=currId%></td>
			<td><%=currName%></td>
			<td><%=currSur%></td>
			<td><%=currDate%></td>
		</tr>

		<%
			}
			}
		%>

	</table>
	
<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>