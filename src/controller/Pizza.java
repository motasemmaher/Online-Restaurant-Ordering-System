package controller;
import java.util.*;

import java.io.IOException;

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
 * Servlet implementation class Pizza
 */
@WebServlet("/Pizza")
public class Pizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final float pizzaPrice = 5.5f;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pizza() {
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
                
		model.Pizza pizza = new model.Pizza("Pizza", req.getParameter("type"), customization, req.getParameter("size"), pizzaPrice);     
		HttpSession session = req.getSession();
		model.User user = (model.User)session.getAttribute("user");
                Query.insertIntoOrder(user.getUsername(), "Pizza", req.getParameter("type"), customization, req.getParameter("size"), "0", "-", pizzaPrice);
		user.addOrder(new model.Order(pizza));
		ServletContext context = req.getServletContext();
		List<model.User> users = (ArrayList<model.User>)context.getAttribute("users");
		users.set(users.indexOf(user), user);
		context.setAttribute("users", users);
		session.setAttribute("user", user);
		RequestDispatcher dis = req.getRequestDispatcher("Restaurant.html");
		dis.forward(req, res);
		
	}

}
