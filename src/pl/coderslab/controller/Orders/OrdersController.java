package pl.coderslab.controller.Orders;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Order;
import pl.coderslab.dao.OrderDao;

@WebServlet("/Orders")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDao cDao = OrderDao.getInstance();
		List<Order> cList = cDao.getAllOrders();
		request.setAttribute("orders", cList);

		request.getRequestDispatcher("/WEB-INF/Orders/orders.jsp").forward(request, response);
	}

}
