package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;



@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    private CategoryDao categoryDao;

	    @Override
	    public void init() throws ServletException {
	    	categoryDao = (CategoryDao) getServletContext().getAttribute("categoryDao");
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	    		throws ServletException, IOException {
	        String idStr = req.getParameter("id");
	        

	        if (idStr == null || idStr.isEmpty()) {
	            resp.sendRedirect("catalog");
	            return;
	        }

	        int id = Integer.parseInt(idStr);
	        categoryDao.deleteById(id);

	        resp.sendRedirect("catalog");
	    }
}

