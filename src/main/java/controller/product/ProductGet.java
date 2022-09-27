package controller.product;

import dao.ProductsDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ProductGet", value = "/ProductGet")
public class ProductGet extends HttpServlet {

    /**
     * Get product from "Products" table
     * by "product_id" request parameter
     * and set "product" as request attribute
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Product product = new ProductsDAO().getProduct(request.getParameter("product_id"));
            request.setAttribute("product", product);
            RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
