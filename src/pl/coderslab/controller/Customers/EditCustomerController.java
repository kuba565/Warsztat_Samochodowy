package pl.coderslab.controller.Customers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.Customer;
import pl.coderslab.dao.CustomerDao;

@WebServlet("/EditCustomer")
public class EditCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/Customers/editCustomer.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String surname = (String) request.getParameter("surname");
		String birthDate = request.getParameter("birthDate");
		int id = Integer.valueOf(request.getParameter("id"));

		CustomerDao cDao = CustomerDao.getInstance();

		Customer customer = new Customer(name, surname, birthDate, id);
		if (cDao.update(customer)) {
			request.setAttribute("cDao", cDao);

			response.sendRedirect("Customers");
		} else {
			response.sendRedirect("EditCustomer");

		}
	}

}
