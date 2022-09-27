package controller;

import dao.OrdersDAO;
import model.Cart;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckOut", value = "/CheckOut")
public class CheckOut extends HttpServlet {

    /**
     * Get information from request parameters
     * and insert information into "Orders" table
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("cart") == null) {
                session.setAttribute("cart", new Cart());
            }
            OrdersDAO dao = new OrdersDAO();
            Cart c = (Cart) session.getAttribute("cart");
            String email = request.getParameter("email");
            String discount = request.getParameter("discount");
            String address = request.getParameter("address");
            dao.insertOrder(email, address, discount, c);
            session.removeAttribute("cart");
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            response.getWriter().println(e);
            e.printStackTrace();
        }
    }
}
