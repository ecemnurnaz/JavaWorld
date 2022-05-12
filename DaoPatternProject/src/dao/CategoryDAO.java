package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryDAO implements BaseDAO<Category> {

	@Override
	public List<Category> findAll() {
		List<Category> categories = new ArrayList<Category>();

		try (Connection connection = ConnectionManager.getConnection()) {

			String query = "select * from category";

			PreparedStatement psmt = connection.prepareStatement(query);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				Category cat = new Category(rs.getInt("id"), rs.getString("name"));
				categories.add(cat);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categories;

	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Category item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Category item) {
		int result = 0;

		try (Connection conn = ConnectionManager.getConnection()) {

			String query = "insert into category(name) values(?)";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, item.getName());

			result = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(Category item) {
		// TODO Auto-generated method stub
		return 0;
	}

}
