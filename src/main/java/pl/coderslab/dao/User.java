package pl.coderslab.dao;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Arrays;

public class User {
    private int id;
    private String email;
    private String username;
    private String hashedPassword;

    public User() {
    }

    public User(int id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
//        if (UserDao.isEmailUnique(email) == true) {
//            this.email = email;
//        }
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.hashedPassword = BCrypt.hashpw(hashedPassword, BCrypt.gensalt());
    }

    public void setHashPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public static User[] addToArray (User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
