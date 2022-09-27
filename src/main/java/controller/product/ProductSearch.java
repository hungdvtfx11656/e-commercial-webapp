package controller.product;

import dao.ProductsDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ProductSearch", value = "/ProductSearch")
public class ProductSearch extends HttpServlet {

    /**
     * Get product list from "Products" table
     * and set product list as request attribute
     * from "search" request parameter
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int page = 1;
        int recordsPerPage = 4;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        ProductsDAO dao = new ProductsDAO();
        String name = request.getParameter("search");
        List<Product> ls = dao.search((page - 1) * recordsPerPage, recordsPerPage, name);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0/recordsPerPage);
        request.setAttribute("products", ls);
        request.setAttribute("no_pages", noOfPages);
        request.setAttribute("current_page", page);
        request.setAttribute("search", name);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

}
