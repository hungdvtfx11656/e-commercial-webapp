package controller.account;

import dao.AccountDAO;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AccountList", value = "/AccountList")
public class AccountList extends HttpServlet {

    /**
     * Get account list from "Accounts" table and
     * set account list as request attribute
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            AccountDAO dao = new AccountDAO();
            List<Account> ls = dao.getList();
            request.setAttribute("account_list", ls);
            request.getRequestDispatcher("admin/accounts.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}