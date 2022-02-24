package myItems.servlet;

import myItems.manager.ItemManager;
import myItems.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class FirstPageServlet extends HttpServlet {
    private final ItemManager itemManager = new ItemManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> last20Items = itemManager.getLast20Items();
        req.setAttribute("items",last20Items);
        req.getRequestDispatcher("/first.jsp").forward(req,resp);



    }
}
