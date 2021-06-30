package pl.coderslab.usersCrud;

import pl.coderslab.dao.User;
import pl.coderslab.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "AddUser", value = "/user/add")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("adminName") == null && session.getAttribute("adminPass") == null) {
            response.sendRedirect("/user/login");
        } else {
            request.getServletContext().getRequestDispatcher("/WEB-INF/addForm.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String newUserName = "";
        String newUserEmail = "";
        String newUserPass = "";

        if (request.getParameter("newUserEmail").matches("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}") && request.getParameter("newUserEmail") != null && request.getParameter("newUserName").matches("[a-z0-9_-]{3,16}") && request.getParameter("newUserName") != null && request.getParameter("newUserPass").matches("[a-z0-9@<>_=+/-]{3,20}") && request.getParameter("newUserPass") != null) {
            newUserName = request.getParameter("newUserName");
            newUserEmail = request.getParameter("newUserEmail");
            newUserPass = request.getParameter("newUserPass");
        } else {
            request.getServletContext().getRequestDispatcher("/WEB-INF/isUserExist.jsp").forward(request, response);
        }

//        UserDao udao = new UserDao();
        User user = new User();
        user.setEmail(newUserEmail);
        user.setUsername(newUserName);
        user.setPassword(newUserPass);

        PrintWriter writer = response.getWriter();
        List<User> existingUsers = (List<User>) session.getAttribute("allUsers");

        boolean isUserExist = false;


        for (User userList : existingUsers) {
            if (userList.getEmail().equals(newUserEmail)) {
                isUserExist = true;
                request.getServletContext().getRequestDispatcher("/WEB-INF/isUserExist.jsp").forward(request, response);
            }
        }
        if (isUserExist == false) {
            UserDao.create(user);
            request.getServletContext().getRequestDispatcher("/WEB-INF/userAdd.jsp").forward(request, response);

        }

        session.setAttribute("isUserExist", isUserExist);
    }
}
