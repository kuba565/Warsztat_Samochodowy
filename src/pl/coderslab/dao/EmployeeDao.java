package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	private static EmployeeDao instance;

	public static EmployeeDao getInstance() {

		if (instance == null) {
			instance = new EmployeeDao();
		}

		return instance;
	}

	private EmployeeDao() {
		try (Connection connection = DbUtil.getConn();) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate("CREATE TABLE IF NOT EXISTS Employees(\n"
						+ "    id INT PRIMARY KEY AUTO_INCREMENT,\n" + "    name TEXT NOT NULL,\n"
						+ "    surname TEXT NOT NULL,\n" + "    address TEXT NOT NULL,\n" + "    phone TEXT NOT NULL,\n"
						+ "    note TEXT NOT NULL,\n" + "    wrkHourCost DECIMAL NOT NULL\n" + ");");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean save(Employee Employee) {

		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO Employees(name, surname, address, phone, note, wrkHourCost) VALUES(?, ?, ?, ?, ?, ?)")) {

				statement.setString(1, Employee.getName());
				statement.setString(2, Employee.getSurname());
				statement.setString(3, Employee.getAddress());
				statement.setString(4, Employee.getPhone());
				statement.setString(5, Employee.getNote());
				statement.setDouble(6, Employee.getWrkHourCost());

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
			try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Employees WHERE id = ?")) {

				statement.setInt(1, id);
				int numRowsAffected = statement.executeUpdate();

				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Employee> getAllEmployees() {
		List<Employee> Employees = new ArrayList<>();

		try (Connection connection = DbUtil.getConn()) {
			try (Statement statement = connection.createStatement()) {

				ResultSet rs = statement.executeQuery("SELECT * FROM Employees");
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String note = rs.getString("note");
					Double wrkHourCost = rs.getDouble("wrkHourCost");
					Employees.add(new Employee(name, surname, address, phone, note, wrkHourCost, id));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Employees;
	}

	public boolean update(Employee Employee) {

		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement(
					"UPDATE Employees SET name=?, surname=?, address=?, phone=?, note=?, wrkHourCost=? WHERE id = ?")) {

				statement.setString(1, Employee.getName());
				statement.setString(2, Employee.getSurname());
				statement.setString(3, Employee.getAddress());
				statement.setString(4, Employee.getPhone());
				statement.setString(5, Employee.getNote());
				statement.setDouble(6, Employee.getWrkHourCost());

				int numRowsAffected = statement.executeUpdate();
				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Employee get(int id) {

		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employees WHERE id = ?")) {

				statement.setInt(1, id);

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String note = rs.getString("note");
					Double wrkHourCost = rs.getDouble("wrkHourCost");
					return new Employee(name, surname, address, phone, note, wrkHourCost);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Employee> search(String phrase) {
		List<Employee> Employees = new ArrayList<>();

		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Employees WHERE name LIKE '%" + phrase + "%'")) {

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					String note = rs.getString("note");
					Double wrkHourCost = rs.getDouble("wrkHourCost");
					Employees.add(new Employee(name, surname, address, phone, note, wrkHourCost, id));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Employees;
	}
}
