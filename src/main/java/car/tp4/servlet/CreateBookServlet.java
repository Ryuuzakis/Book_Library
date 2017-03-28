package car.tp4.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("create get");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/create.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		System.out.println("create post");
		
		System.out.println(request.getParameter("title"));

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/create-valid.jsp");
		request.setAttribute("title", request.getParameter("title"));
		request.setAttribute("author", request.getParameter("author"));
		request.setAttribute("year", request.getParameter("year"));
		dispatcher.forward(request, response);
	}

}
