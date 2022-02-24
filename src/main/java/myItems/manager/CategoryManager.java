package myItems.manager;

import myItems.db.DBConnectionProvider;
import myItems.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
    Connection connection = DBConnectionProvider.getInstance().getConnection();

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(getCategoriesFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;

    }

    private Category getCategoriesFromResultSet(ResultSet resultSet) {
        try {
            return Category
                    .builder()
                    .id(resultSet.getInt(1))
                    .name(resultSet.getString(2))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
