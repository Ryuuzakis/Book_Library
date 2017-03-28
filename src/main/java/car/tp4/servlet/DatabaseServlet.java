package car.tp4.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.tp4.dao.BookDAO;
import car.tp4.dao.DBIInstance;
import car.tp4.entity.Book;

public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = -6459051150998808363L;

	private BookDAO dao = DBIInstance.instance.open(BookDAO.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		dao.dropTable();
		dao.createTable();
		response.getOutputStream().println("Database created");
	}
}
