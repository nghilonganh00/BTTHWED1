/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package login;

import business.User;
import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDB userList = new UserDB();
        userList.addUser(new User("user1", "123456"));
        userList.addUser(new User("user2", "123456"));
        userList.addUser(new User("user3", "123456"));
        userList.addUser(new User("user4", "123456"));
        userList.addUser(new User("user5", "123456"));

        String url = "/index.jsp";
        String message = "";
        String action = request.getParameter("action");

        if (action == null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            boolean isAuth = userList.userExists(username, password);
          
            if (isAuth) {
                request.setAttribute("sucesssMessage", "Đăng nhập thành công");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("failMessage", "Đăng nhập thất bại");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
            }
            
        }
       

    }

}
