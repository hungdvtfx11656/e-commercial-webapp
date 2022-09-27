package controller.account;

import dao.AccountDAO;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Registry", value = "/Registry")
public class Registry extends HttpServlet {

    /**
     * Get registry information from request
     * and insert into "Accounts" table
     * or set "alert" request attribute if "usr" is already taken
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            HttpSession session = request.getSession(true);
            Account a = (Account) session.getAttribute("account");
            if (a == null) a = new Account();
            a.setUsr(request.getParameter("registry_usr"));
            a.setPwd(request.getParameter("registry_pwd"));
            a.setName(request.getParameter("registry_username"));
            a.setAddress(request.getParameter("registry_address"));
            a.setPhone(request.getParameter("registry_phone"));
            AccountDAO dao = new AccountDAO();
            if (!dao.checkUsr(request.getParameter("registry_usr"))) {
                dao.insert(a);
                request.setAttribute("alert_success", "Please login.");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("alert_warning", "This email is already used.");
                RequestDispatcher rd = request.getRequestDispatcher("registry.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
