package com.sale.ecpisalemanagement.service;

import com.sale.ecpisalemanagement.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    final static Connection connection = DbService.getConnection();

    public static List<Category> all() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                categories.add(category);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }

    public static Category get(int id) {
        Category category = new Category();
        String query = "SELECT * FROM categories WHERE id ='" + id + "'";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    public static void create(Category category) {
        String query = "INSERT INTO categories (name, description) VALUES(?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(Category category) {
        String query = "UPDATE categories SET name=?, description=? WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.setInt(3, category.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM categories  WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



