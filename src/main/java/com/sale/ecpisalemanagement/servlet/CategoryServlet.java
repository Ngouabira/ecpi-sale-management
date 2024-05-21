package com.sale.ecpisalemanagement.servlet;

import com.sale.ecpisalemanagement.model.Category;
import com.sale.ecpisalemanagement.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "categoryServlet", urlPatterns = {"/category", "/category/create","/category/update","/category/delete"})
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String route = req.getServletPath();

        if (route.equals("/category")) {
            req.setAttribute("categories", CategoryService.all());
            req.getServletContext().getRequestDispatcher("/category/index.jsp").forward(req, resp);
        }
        else if (route.equals("/category/create")) {
            req.getServletContext().getRequestDispatcher("/category/create.jsp").forward(req, resp);
        }
        else if (route.equals("/category/update")) {
            req.setAttribute("category", CategoryService.get(Integer.parseInt(req.getParameter("id"))));
            req.getServletContext().getRequestDispatcher("/category/update.jsp").forward(req, resp);
        }
        else if (route.equals("/category/delete")) {
            CategoryService.delete(Integer.parseInt(req.getParameter("id")) );
            req.setAttribute("message", "Category deleted successfully");
            resp.sendRedirect(req.getContextPath()+"/category");
        }
        else {
            req.setAttribute("categories", CategoryService.all());
            req.getServletContext().getRequestDispatcher("/category/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String route = req.getServletPath();

        if (route.equals("/category/create")) {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            Category category = new Category(name, description);
            CategoryService.create(category);
            resp.sendRedirect(req.getContextPath()+"/category");
        }
        else if (route.equals("/category/update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            Category category = new Category(id, name, description);
            CategoryService.update(category);
            resp.sendRedirect(req.getContextPath()+"/category");
        }
        else {
            req.setAttribute("categories", CategoryService.all());
            req.getServletContext().getRequestDispatcher("/category/index.jsp").forward(req, resp);
        }
    }
}
