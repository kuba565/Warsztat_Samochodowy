package pl.coderslab.controller.Statuses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.Status;
import pl.coderslab.dao.StatusDao;

@WebServlet("/EditStatus")
public class EditStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/Statuses/editStatus.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String statusS = request.getParameter("status");
		int id = Integer.valueOf(request.getParameter("id"));

		StatusDao cDao = StatusDao.getInstance();

		Status status = new Status(id, statusS);
		if (cDao.update(status)) {
			request.setAttribute("cDao", cDao);

			response.sendRedirect("Statuses");
		} else {
			response.sendRedirect("EditStatus");

		}
	}

}
