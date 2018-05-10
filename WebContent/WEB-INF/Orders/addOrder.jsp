<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add order</title>
</head>
<body>
<%@include file="/WEB-INF/header.jsp" %>
| <a href="AddOrder">add order</a> | 
<a href="EditOrder">edit order</a> | 
<a href="DeleteOrder">delete order</a> |
	<form action="AddOrder" method="post">

		<label> arrivalString: <input type="date" name="arrivalString" />
		</label> <label> repairBeginStringPlan: <input type="date" name="repairBeginStringPlan" />
		</label> <label> repairBeginStringReal: <input type="date" name="repairBeginStringReal" />
		<br>
		</label><label> assignedWorker: <input type="text" name="assignedWorker" />
		</label> <label> problemDesc: <input type="text" name="problemDesc" />
		</label> <label> repairDesc: <input type="text" name="repairDesc" />
		<br>
		</label><label> status: <input type="text" name="status" />
		</label> <label> vehicleRepaired: <input type="text" name="vehicleRepaired" />
		</label> <label> customerRepairCost: <input type="number" name="customerRepairCost" />
		<br>
		</label><label> partsCost: <input type="number" name="partsCost" />
		</label> <label> wrkHourCost: <input type="number" name="wrkHourCost" />
		</label> <label> wrkHours: <input type="number" name="wrkHours" />
		</label> <br>  <input type="submit" value="Wyślij" />

	</form>
	<%@include file="/WEB-INF/footer.jsp" %>
</body>
</html>