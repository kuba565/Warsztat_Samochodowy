package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

	// TODO these steps have to be done manually:
	// $ mysql -uroot -proot
	// mysql> CREATE DATABASE Customers;
	// mysql> USE Customers;

	// FIXME this should be loaded from init-parameters
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_NAME = "Customers";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";

	private static CustomerDao instance;

	public static CustomerDao getInstance() {

		if (instance == null) {
			instance = new CustomerDao();
		}

		return instance;
	}

	private CustomerDao() {
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				try (Statement statement = connection.createStatement()) {
					statement.executeUpdate("CREATE TABLE IF NOT EXISTS Customers(\n"
							+ "    id INT PRIMARY KEY AUTO_INCREMENT,\n" + "    name TEXT NOT NULL,\n"
							+ "    surname TEXT NOT NULL,\n" + "    birthDate DATE NOT NULL\n" + ");");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean save(Customer Customer) {
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				try (PreparedStatement statement = connection
						.prepareStatement("INSERT INTO Customers(name, surname, birthDate) VALUES(?, ?, ?)")) {

					statement.setString(1, Customer.getName());
					statement.setString(2, Customer.getSurname());
					statement.setDate(3, Customer.getBirthDate());

					statement.executeUpdate();
					return true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Customers WHERE id = ?")) {

					statement.setInt(1, id);
					int numRowsAffected = statement.executeUpdate();

					return numRowsAffected > 0;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Customer> getAllCustomers() {
		List<Customer> Customers = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				try (Statement statement = connection.createStatement()) {

					ResultSet rs = statement.executeQuery("SELECT * FROM Customers");
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String surname = rs.getString("surname");
						Date birthDate = rs.getDate("birthDate");
						Customers.add(new Customer(name, surname, birthDate, id));
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Customers;
	}

	public boolean update(Customer Customer) {
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				try (PreparedStatement statement = connection
						.prepareStatement("UPDATE Customers SET name=?, surname=?, birthDate=? WHERE id = ?")) {

					statement.setString(1, Customer.getName());
					statement.setString(2, Customer.getSurname());
					statement.setDate(3, Customer.getBirthDate());

					int numRowsAffected = statement.executeUpdate();
					return numRowsAffected > 0;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Customer get(int id) {
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				try (PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Customers WHERE id = ?")) {

					statement.setInt(1, id);

					ResultSet rs = statement.executeQuery();
					while (rs.next()) {
						String name = rs.getString("name");
						String surname = rs.getString("surname");
						Date birthDate = rs.getDate("birthDate");
						return new Customer(name, surname, birthDate, id);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Customer> search(String phrase) {
		List<Customer> Customers = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				try (PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Customers WHERE name LIKE '%" + phrase + "%'")) {

					ResultSet rs = statement.executeQuery();
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String surname = rs.getString("surname");
						Date birthDate = rs.getDate("birthDate");
						Customers.add(new Customer(name, surname, birthDate, id));
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Customers;
	}
}