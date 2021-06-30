package pl.coderslab.usersCrud;

import pl.coderslab.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConfirmedDeleteUser", value = "/user/confirmDelete")
public class ConfirmedDeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("adminName") == null && session.getAttribute("adminPass") == null) {
            response.sendRedirect("/user/login");
        } else {
            Integer idToDelete = (Integer) session.getAttribute("UserToDelete");
//            UserDao udao = new UserDao();
            UserDao.delete(idToDelete);
            request.getServletContext().getRequestDispatcher("/WEB-INF/deletedUser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
