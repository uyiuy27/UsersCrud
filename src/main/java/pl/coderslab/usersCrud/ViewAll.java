package pl.coderslab.usersCrud;

import pl.coderslab.dao.User;
import pl.coderslab.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "viewAll", value = "/user/list")
public class ViewAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(); // otwieramy sesję

        if (session.getAttribute("adminName") == null && session.getAttribute("adminPass") == null) {
            response.sendRedirect("/user/login");
        } else {

//            UserDao userDao = new UserDao();

            session.setAttribute("allUsers", UserDao.readAll()); // dodajemy atrybut
            // wysyłamy do jsp
            request.getServletContext().getRequestDispatcher("/WEB-INF/viewAll.jsp").forward(request, response);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
