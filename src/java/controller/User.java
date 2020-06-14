package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Error;
import model.Query;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
                System.out.println("user const");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                model.Query query = new model.Query();
		String username = req.getParameter("Username");
                HttpSession session = req.getSession();
		if (query.matchUser(username)) {
			model.User user = new model.User(username);
			ServletContext context = req.getServletContext();
			List<model.User> users = (List<model.User>) context.getAttribute("users");
			if (users == null) {
				users = new ArrayList<model.User>();
				context.setAttribute("users", users);
			}
			users.add(user);
			context.setAttribute("users", users);
			
			session.setAttribute("user", user);
                        
			res.sendRedirect("Restaurant.html");
		} else {
			model.Error error = new Error("invalid usename!");
			session.setAttribute("error", error);
                        res.sendRedirect("view/jsp/login.jsp");
		}
	}
}
