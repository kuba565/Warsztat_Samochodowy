package pl.coderslab.controller.Vehicles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.Vehicle;
import pl.coderslab.dao.VehicleDao;

@WebServlet("/EditVehicle")
public class EditVehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/Vehicles/editVehicle.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String make = (String) request.getParameter("make");
		String model = (String) request.getParameter("model");
		String yearOfProduction = request.getParameter("yearOfProduction");
		String regNumber = (String) request.getParameter("regNumber");
		String nextReview = (String) request.getParameter("nextReview");
		int id = Integer.valueOf(request.getParameter("id"));

		VehicleDao cDao = VehicleDao.getInstance();

		Vehicle vehicle = new Vehicle(id, make, model, yearOfProduction, regNumber, nextReview);
		if (cDao.update(vehicle)) {
			request.setAttribute("cDao", cDao);

			response.sendRedirect("Vehicles");
		} else {
			response.sendRedirect("EditVehicle");

		}
	}

}
