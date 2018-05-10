package pl.coderslab.controller.Orders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.Order;
import pl.coderslab.dao.OrderDao;

@WebServlet("/AddOrder")
public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/Orders/addOrder.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String arrivalString = (String) request.getParameter("arrivalString");
		String repairBeginStringPlan = (String) request.getParameter("repairBeginStringPlan");
		String repairBeginStringReal = request.getParameter("repairBeginStringReal");
		String assignedWorker = (String) request.getParameter("assignedWorker");
		String problemDesc = (String) request.getParameter("problemDesc");
		String repairDesc = request.getParameter("repairDesc");
		String status = (String) request.getParameter("status");
		String vehicleRepaired = request.getParameter("vehicleRepaired");
		Double customerRepairCost = Double.valueOf(request.getParameter("customerRepairCost"));
		Double partsCost = Double.valueOf(request.getParameter("partsCost"));
		Double wrkHourCost = Double.valueOf(request.getParameter("wrkHourCost"));
		int wrkHours = Integer.valueOf(request.getParameter("wrkHours"));

		OrderDao cDao = OrderDao.getInstance();

		Order order = new Order(arrivalString, repairBeginStringPlan, repairBeginStringReal, assignedWorker,
				problemDesc, repairDesc, status, vehicleRepaired, customerRepairCost, partsCost, wrkHourCost, wrkHours);
		cDao.save(order);
		request.setAttribute("cDao", cDao);
		response.sendRedirect("Orders");
	}

}
