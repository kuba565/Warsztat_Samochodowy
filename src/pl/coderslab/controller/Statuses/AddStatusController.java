package pl.coderslab.controller.Statuses;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.dao.Status;
import pl.coderslab.dao.StatusDao;

@WebServlet("/AddStatus")
public class AddStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/Statuses/addStatus.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = (String) request.getParameter("status");
		StatusDao cDao = StatusDao.getInstance();

		Status order = new Status(status);
		cDao.save(order);
		request.setAttribute("cDao", cDao);
		response.sendRedirect("Statuses");
	}

}
