package pl.coderslab.usersCrud;

import pl.coderslab.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewUser", value = "/user/show")
public class ViewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();

        if (session.getAttribute("adminName") == null && session.getAttribute("adminPass") == null) {
            response.sendRedirect("/user/login");
        } else {

//            UserDao udao = new UserDao();
            int userId = 0;
            try {
                userId = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            session.setAttribute("userView", UserDao.read(userId));


            request.getServletContext().getRequestDispatcher("/WEB-INF/viewUser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
