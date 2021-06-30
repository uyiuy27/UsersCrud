package pl.coderslab.usersCrud;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/user/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String adminName = request.getParameter("adminLogin");
        String adminPass = request.getParameter("adminPass");

        if ("Admin".equals(adminName) && adminName != null && "admin".equals(adminPass) && adminPass != null) {
            session.setAttribute("adminName", adminName);
            session.setAttribute("adminPass", adminPass);
            response.sendRedirect("/user/list");
        } else {
            doGet(request, response);
        }


    }
}
