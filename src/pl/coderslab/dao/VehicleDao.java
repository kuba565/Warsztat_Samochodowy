package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

	private static VehicleDao instance;

	public static VehicleDao getInstance() {

		if (instance == null) {
			instance = new VehicleDao();
		}

		return instance;
	}

	private VehicleDao() {
		try (Connection connection = DbUtil.getConn()) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate("CREATE TABLE IF NOT EXISTS Vehicles("
						+ " id INT PRIMARY KEY AUTO_INCREMENT," + "	make TEXT NOT NULL,"
						+ "	model TEXT NOT NULL," + "	yearOfProduction TEXT NOT NULL," + "regNumber TEXT NOT NULL,"
						+ "nextReview TEXT NOT NULL,");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean save(Vehicle Vehicle) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO Vehicles(make, model, yearOfProduction, regNumber, nextReview) VALUES(?, ?, ?, ?, ?)")) {

				statement.setString(1, Vehicle.getMake());
				statement.setString(2, Vehicle.getModel());
				statement.setString(3, Vehicle.getYearOfProduction());
				statement.setString(4, Vehicle.getRegNumber());
				statement.setString(5, Vehicle.getNextReview());

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
			try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Vehicles WHERE id = ?")) {

				statement.setInt(1, id);
				int numRowsAffected = statement.executeUpdate();

				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Vehicle> getAllVehicle() {
		List<Vehicle> Vehicle = new ArrayList<>();
		try (Connection connection = DbUtil.getConn()) {
			try (Statement statement = connection.createStatement()) {

				ResultSet rs = statement.executeQuery("SELECT * FROM Vehicles");
				while (rs.next()) {
					int id = rs.getInt("id");
					String make = rs.getString("make");
					String model = rs.getString("model");
					String yearOfProduction = rs.getString("yearOfProduction");
					String regNumber = rs.getString("regNumber");
					String nextReview = rs.getString("nextReview");
					Vehicle.add(new Vehicle(id, make, model, yearOfProduction, regNumber, nextReview));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Vehicle;
	}

	public boolean update(Vehicle Vehicle) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement(
					"UPDATE Vehicles SET make=?, model=?, yearOfProduction=?, regNumber=?,nextReview=?  WHERE id = ?")) {

				statement.setString(1, Vehicle.getMake());
				statement.setString(2, Vehicle.getModel());
				statement.setString(3, Vehicle.getYearOfProduction());
				statement.setString(4, Vehicle.getRegNumber());
				statement.setString(5, Vehicle.getNextReview());

				int numRowsAffected = statement.executeUpdate();
				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Vehicle get(int id) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Vehicles WHERE id = ?")) {

				statement.setInt(1, id);

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					String make = rs.getString("make");
					String model = rs.getString("model");
					String yearOfProduction = rs.getString("yearOfProduction");
					String regNumber = rs.getString("regNumber");
					String nextReview = rs.getString("nextReview");
					return new Vehicle(id, make, model, yearOfProduction, regNumber, nextReview);
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Vehicle> search(String phrase) {
		List<Vehicle> Vehicle = new ArrayList<>();
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Vehicles WHERE name LIKE '%" + phrase + "%'")) {

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String make = rs.getString("make");
					String model = rs.getString("model");
					String yearOfProduction = rs.getString("yearOfProduction");
					String regNumber = rs.getString("regNumber");
					String nextReview = rs.getString("nextReview");
					Vehicle.add(new Vehicle(id, make, model, yearOfProduction, regNumber, nextReview));
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Vehicle;
	}
}