package servlets;

import domainclass.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserService userService = new UserService();
 
        if (username.isEmpty() && password.isEmpty())
        {
            request.setAttribute("message", "Username and Password field cannot be empty");
            getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
        }
        
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        request.setAttribute("user", u);
        
        if (userService.login(u.getUsername(), u.getPassword()))
        {
            request.setAttribute("usernameMain", u.getUsername());
            getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);
        }
        
        request.setAttribute("message", "Invalid Username/Password");
        getServletContext().getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
        
    }
}
