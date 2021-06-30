package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDao {
    private static final String CREATE_QUERY = "INSERT INTO users (email, username, password) VALUES (?, ?, ?) ";
    private static final String READ_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String READ_ALL = "SELECT * FROM users";
    private static final String UPDATE_QUERY = "UPDATE users SET email = ?, username = ?, password = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";


    public static User create(User user) {
        // żeby działała baza danych
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement ps = conn.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getHashedPassword());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static User read(int id) {
        // żeby działała baza danych
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement ps = conn.prepareStatement(READ_QUERY)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                user.setHashPassword(rs.getString(4));
                return user;
            } else {
//                System.out.println("W bazie nie ma użytkownika o podanym id");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<User> readAll() {
        // żeby działała baza danych
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DBUtil.getConnect();
             PreparedStatement ps = conn.prepareStatement(READ_ALL)) {
//            User[] users = new User[0];
            List<User> users = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setHashPassword(rs.getString("password"));
                users.add(user);
//                user.addToArray(user, users);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static void update(User user) {
        // żeby działała baza danych
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getHashedPassword());
            ps.setInt(4, user.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        // żeby działała baza danych
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DBUtil.getConnect();
             PreparedStatement ps = conn.prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
