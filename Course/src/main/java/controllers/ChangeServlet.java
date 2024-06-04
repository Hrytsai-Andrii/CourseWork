package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import model.Category;
import model.Product;


@WebServlet("/change")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;
       
	@Override
    public void init() throws ServletException {
		categoryDao = (CategoryDao) getServletContext().getAttribute("categoryDao");
    }

	
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		String command = req.getParameter("command");
		if(command.equals("change")) {
		String idStr = req.getParameter("id");
        String name = req.getParameter("name");

        if (idStr == null || name == null || idStr.isEmpty() || name.isEmpty()) {
            resp.sendRedirect("catalog");
            return;
        }

        int id = Integer.parseInt(idStr);
        Category category = new Category(id, name);
        categoryDao.update(category);

        resp.sendRedirect("catalog");
		}else if (command.equals("add")) {
			String idStr = req.getParameter("id");
	        String name = req.getParameter("name");

	        if (idStr == null || name == null || idStr.isEmpty() || name.isEmpty()) {
	            resp.sendRedirect("catalog");
	            return;
	        }

	        int id = Integer.parseInt(idStr);
	        Category category = categoryDao.findById(id);
	        category.addSubcategory(new Category(0, name), categoryDao.lastKey()  + 1);
	        
	        categoryDao.update(category);
	        resp.sendRedirect("catalog");
		}else if (command.equals("addProduct")) {
			String idStr = req.getParameter("id");
	        String name = req.getParameter("name");
	        String priceStr = req.getParameter("price");

	        if (idStr == null || name == null || idStr.isEmpty() || name.isEmpty()) {
	            resp.sendRedirect("catalog");
	            return;
	        }
	        if (priceStr == null || priceStr.isEmpty()) {
	            resp.sendRedirect("catalog");
	            return;
	        }

	        int id = Integer.parseInt(idStr);
	        double price = Double.parseDouble(priceStr);
	        Category category = categoryDao.findById(id);
	        category.addProduct(new Product(0, name, price));
	        
	        categoryDao.update(category);
	        resp.sendRedirect("catalog");
		}
    }

}
