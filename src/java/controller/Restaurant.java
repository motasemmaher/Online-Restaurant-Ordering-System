package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Restaurant
 */
@WebServlet("/Restaurant")
public class Restaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Restaurant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher dis;
		if(req.getParameter("btn").equals("viewOrder")) {
                        //RequestDispatcher rd = req.getRequestDispatcher("Display");
                        //rd.forward(req, res);
			res.sendRedirect("Display");
                        
		}else if(req.getParameter("btn").equals("logout")) {
			
			HttpSession session = req.getSession();
			req.getSession().setAttribute("user", null);
			res.sendRedirect("view/jsp/login.jsp");
		}
		else {
                    System.out.println(req.getParameter("meal"));
			String meal = req.getParameter("meal");
			if( meal.equals("Pizza")) {
				dis = req.getRequestDispatcher("Pizza.html");
				dis.forward(req, res);
			}
			else if( meal.equals("Burger")) {
				dis = req.getRequestDispatcher("Burger.html");
				dis.forward(req, res);
			}
			else if( meal.equals("Pasta")) {
				dis = req.getRequestDispatcher("Pasta.html");
				dis.forward(req, res);
			}
		}
		
	}

}
