package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import database.TestDataBase;
import model.Category;
import model.Product;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
        super.init();
        categoryDao = (CategoryDao) getServletContext().getAttribute("categoryDao");
        TestDataBase.create(categoryDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String productIdStr = req.getParameter("productId");

        if (idStr == null || idStr.isEmpty()) {
            req.setAttribute("categories", categoryDao.findAll());
            req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Category category = categoryDao.findById(id);
        if (category == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }else {
        	req.setAttribute("categories", category);
        	req.getRequestDispatcher("/WEB-INF/jsp/catalog.jsp").forward(req, resp);
        }       

        if (productIdStr != null && !productIdStr.isEmpty()) {
            int productId;
            try {
                productId = Integer.parseInt(productIdStr);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            Product product = category.getProductById(productId);
            if (product == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            req.setAttribute("product", product);
            req.getRequestDispatcher("/WEB-INF/jsp/product.jsp").forward(req, resp);
        }
    }
}



