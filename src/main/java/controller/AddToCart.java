package controller;

import dao.ProductsDAO;
import model.Cart;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCart", value = "/AddToCart")
public class AddToCart extends HttpServlet {

    /**
     * Add product to "cart" session attribute
     * by "product_id" request parameter
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession(true);
            int id = Integer.parseInt(request.getParameter("product_id"));
            String action = request.getParameter("action");
            if (action != null && action.equalsIgnoreCase("add")) {
                if (session.getAttribute("cart") == null) {
                    session.setAttribute("cart", new Cart());
                }
                Product p = new ProductsDAO().getProduct("" + id);
                Cart c = (Cart) session.getAttribute("cart");
                c.add(new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getSrc(), p.getType(), p.getBrand(), 1));
            } else if (action != null && action.equalsIgnoreCase("remove")) {
                Cart c = (Cart) session.getAttribute("cart");
                c.remove(id);
            }
            response.sendRedirect("cart.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
