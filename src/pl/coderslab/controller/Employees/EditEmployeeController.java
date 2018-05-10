package pl.coderslab.controller.Employees;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.Employee;
import pl.coderslab.dao.EmployeeDao;

@WebServlet("/EditEmployee")
public class EditEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/Employees/editEmployee.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String surname = (String) request.getParameter("surname");
		String address = request.getParameter("address");
		String phone = (String) request.getParameter("phone");
		String note = request.getParameter("note");
		Double wrkHourCost = Double.valueOf(request.getParameter("wrkHourCost"));
		int id = Integer.valueOf(request.getParameter("id"));

		EmployeeDao cDao = EmployeeDao.getInstance();

		Employee employee = new Employee(name, surname, address, phone, note, wrkHourCost, id);
		if (cDao.update(employee)) {
			request.setAttribute("cDao", cDao);

			response.sendRedirect("Employees");
		} else {
			response.sendRedirect("EditEmployee");

		}
	}

}
