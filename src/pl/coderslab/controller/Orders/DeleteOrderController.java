package pl.coderslab.controller.Orders;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.OrderDao;


@WebServlet("/DeleteOrder")
public class DeleteOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Orders/deleteOrder.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));

		OrderDao cDao = OrderDao.getInstance();

		
		if (cDao.delete(id)) {
			request.setAttribute("cDao", cDao);

			response.sendRedirect("Orders");
		} else {
			response.sendRedirect("DeleteOrder");

		}

	}

}
