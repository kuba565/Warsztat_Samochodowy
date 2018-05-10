<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>

<%@ page import="pl.coderslab.dao.Order"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customers</title>
</head>
<body>
	<%@include file="/WEB-INF/header.jsp"%>
	|
	<a href="AddOrder">add order</a> |
	<a href="EditOrder">edit order</a> |
	<a href="DeleteOrder">delete order</a> |

	<table>
		<tr>
			<th>id</th>
			<th>car arrived at:</th>
			<th>Planned beginning repair date</th>
			<th>Real beginning repair date</th>
			<th>Assigned employee</th>
			<th>Problem description</th>
			<th>Repair finished at</th>
			<th>Status</th>
			<th>Vehicle repaired</th>
			<th>repair cost</th>
			<th>the cost of parts</th>
			<th>work hour's cost</th>
			<th>work hours amount</th>
		</tr>
		<%
			ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");

			if (orders != null) {
				for (Order order : orders) {
					String currArrival = order.getArrivalString();
					String currPlan = order.getRepairBeginStringPlan();
					String currReal = order.getRepairBeginStringReal();
					String currWorker = order.getAssignedWorker();
					String currProblemDesc = order.getProblemDesc();
					String currRepairDate = order.getRepairDesc();
					String currStatus = order.getStatus();
					String currVehicle = order.getVehicleRepaired();
					Double currRepairCost = order.getCustomerRepairCost();
					Double currPartsCost = order.getPartsCost();
					Double currWrkHourCost = order.getWrkHourCost();
					int currWrkHours = order.getWrkHours();
					int currId = order.getId();
		%>

		<tr>
			<td><%=currId%></td>
			<td><%=currArrival%></td>
			<td><%=currPlan%></td>
			<td><%=currReal%></td>
			<td><%=currWorker%></td>
			<td><%=currProblemDesc%></td>
			<td><%=currRepairDate%></td>
			<td><%=currStatus%></td>
			<td><%=currVehicle%></td>
			<td><%=currRepairCost%></td>
			<td><%=currPartsCost%></td>
			<td><%=currWrkHourCost%></td>
		</tr>

		<%
			}
			}
		%>

	</table>

	<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>