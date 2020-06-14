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
 * Servlet implementation class Pasta
 */
@WebServlet("/Pasta")
public class Pasta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final float pastaPrice = 4.4f;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pasta() {
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
                
		model.Pasta pasta = new model.Pasta("Pasta", req.getParameter("type"), customization, req.getParameter("meat"), pastaPrice);     
		HttpSession session = req.getSession();
		model.User user = (model.User)session.getAttribute("user");
                Query.insertIntoOrder(user.getUsername(), "Pasta", req.getParameter("type"), customization, "-", "0", req.getParameter("meat"), pastaPrice);
		user.addOrder(new model.Order(pasta));
		ServletContext context = req.getServletContext();
		List<model.User> users = (ArrayList<model.User>)context.getAttribute("users");
		users.set(users.indexOf(user), user);
		context.setAttribute("users", users);
		session.setAttribute("user", user);
		RequestDispatcher dis = req.getRequestDispatcher("Restaurant.html");
		dis.forward(req, res);
		
	}

}
