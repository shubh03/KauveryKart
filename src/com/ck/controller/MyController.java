package com.ck.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ck.dao.DBStorage;
import com.ck.model.User;
import com.ck.model.helper.SendMail;

@WebServlet("/Controller.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBStorage obj = new DBStorage();

		String button = request.getParameter("submit");
		System.out.println(button);
		SendMail mail = new SendMail();
		if ("Register".equals(button)) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if (name.length() == 0 || email.length() == 0 || password.length() == 0) {
				name = null;
				password = null;
				email = null;
			}
			User user = new User(name, email, password);

			boolean b;
			try {
				b = obj.saveUser(user);
				System.out.println("value of b:" + b);
				if (b) {
					// HttpSession session = request.getSession();
					request.setAttribute("sucess", "registered sucessfully");
					mail.sendMail(email);
				} else {
					request.setAttribute("sucess", "registration have failed! Please enter data in all fields");

				}
				RequestDispatcher rd = request.getRequestDispatcher("sucess.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();

			}
		}

		else if (button.equals("Login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email + "......." + password);
			User user = new User(email, password);
			User u = obj.varifyUser(user);
			System.out.println(u);
			if (u != null) {
				response.sendRedirect("profile.jsp?msg=hello" + u.getName());
			} else {

				response.sendRedirect("login.jsp");
			}

		}

	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init()");
	}

}
