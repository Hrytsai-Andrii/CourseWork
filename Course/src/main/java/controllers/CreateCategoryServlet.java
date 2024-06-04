package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import model.Category;

import java.io.IOException;

@WebServlet("/createCategory")
public class CreateCategoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
        categoryDao = (CategoryDao) getServletContext().getAttribute("categoryDao");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        String name = req.getParameter("name");

        if (name == null || name.isEmpty()) {
            resp.sendRedirect("catalog");
            return;
        }

        Category category = new Category(0, name);
        categoryDao.create(category);

        resp.sendRedirect("catalog");
    }
}
