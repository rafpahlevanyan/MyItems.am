package myItems.servlet;

import myItems.manager.ItemManager;
import myItems.model.Item;
import myItems.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/userHome")
public class UserHomeServlet extends HttpServlet {
    private ItemManager itemManager = new ItemManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        List<Item> allItems = itemManager.getLast20Items();
        req.setAttribute("items", allItems);
        req.getRequestDispatcher("/userHome.jsp").forward(req, resp);

    }
}
