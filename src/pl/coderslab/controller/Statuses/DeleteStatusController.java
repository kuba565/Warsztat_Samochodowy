package pl.coderslab.controller.Statuses;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.StatusDao;

@WebServlet("/DeleteStatus")
public class DeleteStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Statuses/deleteStatus.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.valueOf(request.getParameter("id"));

		StatusDao cDao = StatusDao.getInstance();

		if (cDao.delete(id)) {
			request.setAttribute("cDao", cDao);

			response.sendRedirect("Statuses");
		} else {
			response.sendRedirect("DeleteStatus");

		}

	}

}
