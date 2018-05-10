<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>

<%@ page import="pl.coderslab.dao.Vehicle"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customers</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddVehicle">add vehicle</a> | 
<a href="EditVehicle">edit vehicle</a> | 
<a href="DeleteVehicle">delete vehicle</a> |

	<table>
		<tr>
			<th>id</th>
			<th>Make</th>
			<th>Model</th>
			<th>Next review</th>
			<th>Reg. number</th>
			<th>Year of production</th>
		</tr>
		<%
			ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) request.getAttribute("vehicles");
		
			if (vehicles != null) {
				for (Vehicle vehicle : vehicles) {
					String currMake = vehicle.getMake();
					String currModel = vehicle.getModel();
					String currReview = vehicle.getNextReview();
					String currReg = vehicle.getRegNumber();
					String currProduction = vehicle.getYearOfProduction();
					int currId = vehicle.getId();
		%>

		<tr>
			<td><%=currId%></td>
			<td><%=currMake%></td>
			<td><%=currModel%></td>
			<td><%=currReview%></td>
			<td><%=currReg%></td>
			<td><%=currProduction%></td>
		</tr>

		<%
			}
			}
		%>

	</table>
	
<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>