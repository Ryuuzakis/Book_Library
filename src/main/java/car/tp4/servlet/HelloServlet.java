package car.tp4.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = -6459051150998808363L;


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/hello.jsp");
		dispatcher.forward(request, response);
	}


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/hello.jsp");
		request.setAttribute("name", request.getParameter("name"));
		dispatcher.forward(request, response);
	}
}
