package myItems.manager;

import myItems.db.DBConnectionProvider;
import myItems.model.Category;
import myItems.model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private UserManager userManager = new UserManager();

    public void addItem(Item item) {
        String sql = "insert into item(title,price,category_id,pic_url,user_id) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, item.getTitle());
            ps.setInt(2, item.getPrice());
            ps.setInt(3, item.getCategoryId());
            ps.setString(4, item.getPicUrl());
            ps.setInt(5, item.getUserId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getLast20Items() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM item ORDER BY id DESC limit 20";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                items.add(getItemFromResultSet(resultSet));
            }
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private Item getItemFromResultSet(ResultSet resultSet) {
        try {
            return Item
                    .builder()
                    .id(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .price(resultSet.getInt(3))
                    .categoryId(resultSet.getInt(4))
                    .picUrl(resultSet.getString(5))
                    .userId(resultSet.getInt(6))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Item> getAllItemsByUser(int userId){
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM item WHERE user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                items.add(getItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public boolean deleteItem(int id){
        String sql = "DELETE FREE item WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Item> getByCategoryId(int id){
            List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM item WHERE category_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                 items.add(getItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }


}
