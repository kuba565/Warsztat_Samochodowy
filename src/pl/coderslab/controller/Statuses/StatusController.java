package pl.coderslab.controller.Statuses;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Status;
import pl.coderslab.dao.StatusDao;

@WebServlet("/Statuses")
public class StatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StatusDao cDao = StatusDao.getInstance();
		List<Status> cList = cDao.getAllStatus();
		request.setAttribute("statuses", cList);

		request.getRequestDispatcher("/WEB-INF/Statuses/statuses.jsp").forward(request, response);
	}

}
