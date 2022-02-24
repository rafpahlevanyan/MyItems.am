package myItems.servlet;

import myItems.manager.UserManager;
import myItems.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    private UserManager userManager= new UserManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        User user = userManager.getByEmailAndPassword(email,password);

        if (user == null){
            resp.sendRedirect("/");

        }else {
            session.setAttribute("user",user);
            resp.sendRedirect("/userHome");
        }

    }
}
