package pl.coderslab.controller.Customers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Customer;
import pl.coderslab.dao.CustomerDao;

@WebServlet("/Customers")
public class CustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDao cDao = CustomerDao.getInstance();
		List<Customer> cList = cDao.getAllCustomers();
		request.setAttribute("customers", cList);

		request.getRequestDispatcher("/WEB-INF/Customers/customers.jsp").forward(request, response);
	}

}
