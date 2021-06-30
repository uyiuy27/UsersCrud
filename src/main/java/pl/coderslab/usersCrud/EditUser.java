package pl.coderslab.usersCrud;

import pl.coderslab.dao.User;
import pl.coderslab.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "editUser", value = "/user/edit")
public class EditUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("adminName") == null && session.getAttribute("adminPass") == null) {
            response.sendRedirect("/user/login");
        } else {
            String id = request.getParameter("id");
//            UserDao udao = new UserDao();
            int userId = 0;
            try {
                userId = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            UserDao.read(userId);

            session.setAttribute("userId", userId);

            request.getServletContext().getRequestDispatcher("/WEB-INF/editForm.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String editUserName = "";
        String editUserEmail = "";
        String editUserPass = "";
        Integer userId = (Integer) session.getAttribute("userId");
        List<User> existingUsers = (List<User>) session.getAttribute("allUsers");

        if (request.getParameter("editUserName").matches("[a-z0-9_-]{3,16}") && request.getParameter("editUserName") != null) {
            editUserName = request.getParameter("editUserName");
        } else {
            for (User userList : existingUsers) {
                if (userList.getId() == (userId)) {
                    editUserName = userList.getUsername();
                }
            }
        }

        if (request.getParameter("editUserEmail").matches("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}") && request.getParameter("editUserEmail") != null) {
            editUserEmail = request.getParameter("editUserEmail");
        } else {
            for (User userList : existingUsers) {
                if (userList.getId() == (userId)) {
                    editUserEmail = userList.getEmail();
                }
            }
        }

        if (request.getParameter("editUserPass").matches("[a-z0-9@<>_=+/-]{3,20}") && request.getParameter("editUserPass") != null) {
            editUserPass = request.getParameter("editUserPass");
        } else {
            for (User userList : existingUsers) {
                if (userList.getId() == (userId)) {
                    editUserPass = userList.getHashedPassword();
                }
            }
        }

        User user = new User();
        user.setId(userId);
        user.setUsername(editUserName);
        user.setEmail(editUserEmail);
        user.setPassword(editUserPass);

//        UserDao udao = new UserDao();
        UserDao.update(user);

        request.getServletContext().getRequestDispatcher("/WEB-INF/editedUser.jsp").forward(request, response);
    }
}
