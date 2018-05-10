package pl.coderslab.controller.Customers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CustomerDao;


@WebServlet("/DeleteCustomer")
public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Customers/deleteCustomer.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));

		CustomerDao cDao = CustomerDao.getInstance();

		
		if (cDao.delete(id)) {
			request.setAttribute("cDao", cDao);

			response.sendRedirect("Customers");
		} else {
			response.sendRedirect("DeleteCustomer");

		}

	}

}
