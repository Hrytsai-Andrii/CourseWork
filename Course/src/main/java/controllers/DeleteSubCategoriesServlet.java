package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import model.Category;

/**
 * Servlet implementation class DeleteSubCategoriesServlet
 */
@WebServlet("/deleteSub")
public class DeleteSubCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
    	categoryDao = (CategoryDao) getServletContext().getAttribute("categoryDao");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 String idStr = request.getParameter("id");
		 String parentStr = request.getParameter("parent");

	        if (idStr == null || idStr.isEmpty()) {
	        	response.sendRedirect("catalog");
	            return;
	        }
	        
	        if (parentStr == null || parentStr.isEmpty()) {
	        	response.sendRedirect("catalog");
	            return;
	        }

	        int id = Integer.parseInt(idStr);
	        int parentId = Integer.parseInt(parentStr);
	        Category c = categoryDao.findById(parentId);
	        c.deleteCategoryById(id);

	        response.sendRedirect("catalog");
	}

}
