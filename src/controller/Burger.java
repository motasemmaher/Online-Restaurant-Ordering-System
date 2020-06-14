package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Query;

/**
 * Servlet implementation class Burger
 */
@WebServlet("/Burger")
public class Burger extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final float burgerPrice = 3.2f;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Burger() {
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
		// TODO Auto-generated method stub
                
                String customization = "";
                String[] adds = req.getParameterValues("addition");
                for(int i = 0; i < adds.length; ++i) {
                    customization += adds[i] + (i==adds.length-1? "" : ",");
                }
                
		model.Burger burger = new model.Burger("Burger", req.getParameter("type"), customization,Integer.parseInt(req.getParameter("weight")), burgerPrice);     
		HttpSession session = req.getSession();
		model.User user = (model.User)session.getAttribute("user");
                Query.insertIntoOrder(user.getUsername(), "Burger", req.getParameter("type"), customization, "-", req.getParameter("weight"), "-", burgerPrice);
		user.addOrder(new model.Order(burger));
		ServletContext context = req.getServletContext();
		List<model.User> users = (ArrayList<model.User>)context.getAttribute("users");
		users.set(users.indexOf(user), user);
		context.setAttribute("users", users);
		session.setAttribute("user", user);
		RequestDispatcher dis = req.getRequestDispatcher("Restaurant.html");
		dis.forward(req, res);
		
	}

}
