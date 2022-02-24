package myItems.servlet;

import myItems.manager.CategoryManager;
import myItems.manager.ItemManager;
import myItems.model.Category;
import myItems.model.Item;
import myItems.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/showItems")
public class ShowItemsServlet extends HttpServlet {

    CategoryManager cm = new CategoryManager();
    ItemManager im = new ItemManager();
    User user = new User();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String catId = req.getParameter("catId");

        List<Item> items = im.getByCategoryId(Integer.parseInt(catId));

        req.setAttribute("items", items);
        req.getRequestDispatcher("/first.jsp").forward(req, resp);


    }
}
