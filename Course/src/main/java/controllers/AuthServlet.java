package controllers;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = (UserDao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	String command = req.getParameter("command");
    	if(command.equals("login")) {
    		String name = req.getParameter("name");
            String password = req.getParameter("password");

            if (name == null || name.isEmpty() || password == null || password.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            User user = userDao.findByName(name);

            if (user == null || !user.getPassword().equals(password)) {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            req.getSession().setAttribute("user", user);

            resp.sendRedirect("catalog");
    	}else if(command.equals("logout")){
            req.getSession().invalidate();

            resp.sendRedirect("catalog");
    	}
        
    }
}

