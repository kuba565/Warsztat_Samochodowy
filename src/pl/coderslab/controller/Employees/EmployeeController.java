package pl.coderslab.controller.Employees;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Employee;
import pl.coderslab.dao.EmployeeDao;

@WebServlet("/Employees")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDao cDao = EmployeeDao.getInstance();
		List<Employee> cList = cDao.getAllEmployees();
		request.setAttribute("employees", cList);

		request.getRequestDispatcher("/WEB-INF/Employees/employees.jsp").forward(request, response);
	}

}
