package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

	private static CustomerDao instance;

	public static CustomerDao getInstance() {

		if (instance == null) {
			instance = new CustomerDao();
		}

		return instance;
	}

	private CustomerDao() {

		try (Connection connection = DbUtil.getConn();) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate("CREATE TABLE IF NOT EXISTS Customers(\n"
						+ "    id INT PRIMARY KEY AUTO_INCREMENT,\n" 
						+ "    name TEXT NOT NULL,\n"
						+ "    surname TEXT NOT NULL,\n" 
						+ "    birthDate DATE NOT NULL\n" + ");");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean save(Customer Customer) {

		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection
					.prepareStatement("INSERT INTO Customers(name, surname, birthDate) VALUES(?, ?, ?)")) {

				statement.setString(1, Customer.getName());
				statement.setString(2, Customer.getSurname());
				statement.setString(3, Customer.getBirthDate());

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
			try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Customers WHERE id = ?")) {

				statement.setInt(1, id);
				int numRowsAffected = statement.executeUpdate();

				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Customer> getAllCustomers() {
		List<Customer> Customers = new ArrayList<>();

		try (Connection connection = DbUtil.getConn()) {
			try (Statement statement = connection.createStatement()) {

				ResultSet rs = statement.executeQuery("SELECT * FROM Customers");
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String birthDate = rs.getString("birthDate");
					Customers.add(new Customer(name, surname, birthDate, id));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Customers;
	}

	public boolean update(Customer Customer) {

		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection
					.prepareStatement("UPDATE Customers SET name=?, surname=?, birthDate=? WHERE id = ?")) {

				statement.setString(1, Customer.getName());
				statement.setString(2, Customer.getSurname());
				statement.setString(3, Customer.getBirthDate());
				statement.setInt(4, Customer.getId());

				int numRowsAffected = statement.executeUpdate();
				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Customer get(int id) {

		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customers WHERE id = ?")) {

				statement.setInt(1, id);

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String birthDate = rs.getString("birthDate");
					return new Customer(name, surname, birthDate, id);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Customer> search(String phrase) {
		List<Customer> Customers = new ArrayList<>();

		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Customers WHERE name LIKE '%" + phrase + "%'")) {

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String birthDate = rs.getString("birthDate");
					Customers.add(new Customer(name, surname, birthDate, id));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Customers;
	}
}