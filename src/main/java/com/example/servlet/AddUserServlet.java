package com.example.servlet;
import com.example.User;
import com.example.Warehouse;

import  javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/add")
public class AddUserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName= req.getParameter("firstName");
        String lastName= req.getParameter("lastName");
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        Warehouse.getInstance().addUser(user);
        req.setAttribute("user",firstName+" "+lastName);
        req.getRequestDispatcher("/add.jsp").forward(req,resp);
    }
}
