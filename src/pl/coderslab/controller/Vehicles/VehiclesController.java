package pl.coderslab.controller.Vehicles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Vehicle;
import pl.coderslab.dao.VehicleDao;

@WebServlet("/Vehicles")
public class VehiclesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VehicleDao cDao = VehicleDao.getInstance();
		List<Vehicle> cList = cDao.getAllVehicle();
		request.setAttribute("vehicles", cList);

		request.getRequestDispatcher("/WEB-INF/Vehicles/vehicles.jsp").forward(request, response);
	}

}
