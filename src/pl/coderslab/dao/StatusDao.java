package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusDao {

	private static StatusDao instance;

	public static StatusDao getInstance() {

		if (instance == null) {
			instance = new StatusDao();
		}

		return instance;
	}

	private StatusDao() {
		try (Connection connection = DbUtil.getConn()) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate("CREATE TABLE IF NOT EXISTS Statuses(\n"
						+ "    id INT PRIMARY KEY AUTO_INCREMENT,\n" + "    status TEXT NOT NULL);");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean save(Status Status) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Statuses(status) VALUES(?)")) {

				statement.setString(1, Status.getStatus());

				statement.executeUpdate();
				return true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Statuses WHERE id = ?")) {

				statement.setInt(1, id);
				int numRowsAffected = statement.executeUpdate();

				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Status> getAllStatus() {
		List<Status> Status = new ArrayList<>();
		try (Connection connection = DbUtil.getConn()) {
			try (Statement statement = connection.createStatement()) {

				ResultSet rs = statement.executeQuery("SELECT * FROM Statuses");
				while (rs.next()) {
					int id = rs.getInt("id");
					String status = rs.getString("status");
					Status.add(new Status(id, status));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Status;
	}

	public boolean update(Status Status) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement("UPDATE Statuses SET status=? WHERE id = ?")) {

				statement.setString(1, Status.getStatus());

				int numRowsAffected = statement.executeUpdate();
				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Status get(int id) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Statuses WHERE id = ?")) {

				statement.setInt(1, id);

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					String status = rs.getString("status");
					return new Status(id, status);
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Status> search(String phrase) {
		List<Status> Status = new ArrayList<>();
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Statuses WHERE name LIKE '%" + phrase + "%'")) {

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String status = rs.getString("status");
					Status.add(new Status(id, status));
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Status;
	}
}