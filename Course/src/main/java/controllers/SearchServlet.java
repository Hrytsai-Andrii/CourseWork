package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import model.Product;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryDao = (CategoryDao) getServletContext().getAttribute("categoryDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null || name.isEmpty()) {
            resp.sendRedirect("catalog");
            return;
        }
        List<Product> products = categoryDao.findProductsByName(name);
        if (products.isEmpty()) {
            req.setAttribute("message", "No products found");
            req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(req, resp);
    }
}

