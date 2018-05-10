package pl.coderslab.controller.Vehicles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.VehicleDao;

@WebServlet("/DeleteVehicle")
public class DeleteVehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Vehicles/deleteVehicle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.valueOf(request.getParameter("id"));

		VehicleDao cDao = VehicleDao.getInstance();

		if (cDao.delete(id)) {
			request.setAttribute("cDao", cDao);

			response.sendRedirect("Vehicles");
		} else {
			response.sendRedirect("DeleteVehicle");

		}

	}

}
