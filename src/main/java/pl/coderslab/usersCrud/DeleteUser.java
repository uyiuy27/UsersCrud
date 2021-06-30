package pl.coderslab.usersCrud;

import pl.coderslab.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUser", value = "/user/delete")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("adminName") == null && session.getAttribute("adminPass") == null) {
            response.sendRedirect("/user/login");
        } else {
            String idToDelete = request.getParameter("id");
            try {
                int userId = Integer.parseInt(idToDelete);
                session.setAttribute("UserToDelete", userId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("/user/list");
            }
            request.getServletContext().getRequestDispatcher("/WEB-INF/deleteUser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
