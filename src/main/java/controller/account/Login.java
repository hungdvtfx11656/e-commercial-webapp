package controller.account;

import dao.AccountDAO;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

    /**
     * Get "usr" and "pwd" from request parameters
     * and set "account" session attribute if "usr" and "pwd" are matched
     * or set "alert" request attribute if "usr" and "pwd" are not matched
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("account") != null) session.invalidate();
            Account a = (Account) session.getAttribute("account");
            String login_usr = request.getParameter("login_usr");
            String login_pwd = request.getParameter("login_pwd");
            AccountDAO dao = new AccountDAO();
            if (dao.checkUsr(login_usr)) {
                Account check = dao.getAccount(login_usr, login_pwd);
                if (check != null) {
                    check.setCheck(0);
                    session.setAttribute("account", check);
                    if (request.getParameter("login_remember") != null) {
                        Cookie c_usr = new Cookie("login_usr", login_usr);
                        Cookie c_pwd = new Cookie("login_pwd", login_pwd);
                        c_usr.setMaxAge(60*60*24);
                        c_pwd.setMaxAge(60*60*24);
                        response.addCookie(c_usr);
                        response.addCookie(c_pwd);
                    }
                    response.sendRedirect("index.jsp");
                } else {
                    request.setAttribute("alert_warning", "Wrong password.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("alert_warning", "Email is not registered.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
