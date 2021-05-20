package controller;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginRegister", value = "/loginRegister")
public class LoginRegister extends HttpServlet {
    public LoginRegister() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO cd = new CustomerDAOImpl();
        String userEmail = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String submitType = request.getParameter("submit");
        Customer c = null;
        try {
            c = cd.getCustomer(userEmail,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(submitType.equals("Login") && c!=null && c.getEmail()!=null){
            request.getRequestDispatcher("cabinet.jsp");
        }else if (submitType.equals("register")){
            c.setEmail(request.getParameter(userEmail));
            c.setPassword(password);
            c.setFirstName(firstName);
            c.setLastName(lastName);
            int ageNumerical = Integer.parseInt(age);
            c.setAge(ageNumerical);
            c.setGender(gender);
            cd.insertCustomer(c);
            request.setAttribute("successMessage","Registration is done, please login!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else {
            request.setAttribute("message","Data not found, click on register");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
