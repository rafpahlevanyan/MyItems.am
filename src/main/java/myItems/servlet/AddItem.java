package myItems.servlet;

import myItems.manager.ItemManager;
import myItems.model.Item;
import myItems.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;


@WebServlet(urlPatterns = "/addItem")
@MultipartConfig(fileSizeThreshold = 1048 * 1048,
        maxFileSize = 1048 * 1048 * 5,
        maxRequestSize = 1048 * 1048 * 5 * 5)
public class AddItem extends HttpServlet {

    private ItemManager itemManager = new ItemManager();

    private final String UPLOAD_DIR = "C:\\Users\\User\\IdeaProjects\\MyItems.am\\upload";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String title = req.getParameter("title");
        int price = Integer.parseInt(req.getParameter("price"));
        int categoryId = Integer.parseInt(req.getParameter("category_id"));


        Item item = Item.builder()
                .title(title)
                .price(price)
                .categoryId(categoryId)
                .userId(user.getId())
                .build();
        for (Part part : req.getParts()) {
            if (getFileName(part) != null) {
                String fileName = System.currentTimeMillis() + getFileName(part);
                String fullFileName = UPLOAD_DIR + File.separator + fileName;
                part.write(fullFileName);
                item.setPicUrl(fileName);
            }
        }
        itemManager.addItem(item);
        resp.sendRedirect("/userHome");
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return null;
    }
}
