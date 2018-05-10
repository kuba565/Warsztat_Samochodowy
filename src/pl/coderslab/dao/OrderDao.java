package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

	private static OrderDao instance;

	public static OrderDao getInstance() {

		if (instance == null) {
			instance = new OrderDao();
		}

		return instance;
	}

	private OrderDao() {

		try (Connection connection = DbUtil.getConn()) {
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate("CREATE TABLE IF NOT EXISTS Orders(\n" + " id INT PRIMARY KEY AUTO_INCREMENT,\n"
						+ "	arrivalString TEXT NOT NULL," + "	repairBeginStringPlan TEXT NOT NULL,"
						+ "	repairBeginStringReal TEXT NOT NULL," + "	assignedWorker TEXT NOT NULL,"
						+ "	problemDesc TEXT NOT NULL," + "	repairDesc TEXT NOT NULL," + "	status TEXT NOT NULL,"
						+ "	vehicleRepaired TEXT NOT NULL," + "	customerRepairCost DECIMAL NOT NULL,"
						+ "	partsCost DECIMAL NOT NULL," + "	wrkHourCost DECIMAL NOT NULL,"
						+ "	wrkHours INT NOT NULL");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean save(Order Order) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO Orders(arrivalString, repairBeginStringPlan, repairBeginStringReal, assignedWorker, problemDesc,"
							+ " repairDesc, status, vehicleRepaired, customerRepairCost, partsCost, wrkHourCost, wrkHours)"
							+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

				statement.setString(1, Order.getArrivalString());
				statement.setString(2, Order.getRepairBeginStringPlan());
				statement.setString(3, Order.getRepairBeginStringReal());
				statement.setString(4, Order.getAssignedWorker());
				statement.setString(5, Order.getProblemDesc());
				statement.setString(6, Order.getRepairDesc());
				statement.setString(7, Order.getStatus());
				statement.setString(8, Order.getVehicleRepaired());
				statement.setDouble(9, Order.getCustomerRepairCost());
				statement.setDouble(10, Order.getPartsCost());
				statement.setDouble(11, Order.getWrkHourCost());
				statement.setInt(12, Order.getWrkHours());

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
			try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE id = ?")) {

				statement.setInt(1, id);
				int numRowsAffected = statement.executeUpdate();

				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<Order> getAllOrders() {
		List<Order> Order = new ArrayList<>();
		try (Connection connection = DbUtil.getConn()) {
			try (Statement statement = connection.createStatement()) {

				ResultSet rs = statement.executeQuery("SELECT * FROM Orders");
				while (rs.next()) {
					int id = rs.getInt("id");
					String arrivalString = rs.getString("arrivalString");
					String repairBeginStringPlan = rs.getString("repairBeginStringPlan");
					String repairBeginStringReal = rs.getString("repairBeginStringReal");
					String assignedWorker = rs.getString("assignedWorker");
					String problemDesc = rs.getString("problemDesc");
					String repairDesc = rs.getString("repairDesc");
					String status = rs.getString("status");
					String vehicleRepaired = rs.getString("vehicleRepaired");
					Double customerRepairCost = rs.getDouble("customerRepairCost");
					Double partsCost = rs.getDouble("customerRepairCost");
					Double wrkHourCost = rs.getDouble("customerRepairCost");
					int wrkHours = rs.getInt("wrkHours");
					Order.add(new Order(id, arrivalString, repairBeginStringPlan, repairBeginStringReal, assignedWorker,
							problemDesc, repairDesc, status, vehicleRepaired, customerRepairCost, partsCost,
							wrkHourCost, wrkHours));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Order;
	}

	public boolean update(Order Order) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement(
					"UPDATE Orders SET arrivalString=?, repairBeginStringPlan=?, repairBeginStringReal=?,"
							+ " assignedWorker=?,problemDesc=?, repairDesc=?, status=?, vehicleRepaired=?,"
							+ " customerRepairCost=?, partsCost=?, wrkHourCost=?, wrkHours=?  WHERE id = ?")) {

				statement.setString(1, Order.getArrivalString());
				statement.setString(2, Order.getRepairBeginStringPlan());
				statement.setString(3, Order.getRepairBeginStringReal());
				statement.setString(4, Order.getAssignedWorker());
				statement.setString(5, Order.getProblemDesc());
				statement.setString(6, Order.getRepairDesc());
				statement.setString(7, Order.getStatus());
				statement.setString(8, Order.getVehicleRepaired());
				statement.setDouble(9, Order.getCustomerRepairCost());
				statement.setDouble(10, Order.getPartsCost());
				statement.setDouble(11, Order.getWrkHourCost());
				statement.setInt(12, Order.getWrkHours());

				int numRowsAffected = statement.executeUpdate();
				return numRowsAffected > 0;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Order get(int id) {
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE id = ?")) {

				statement.setInt(1, id);

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					String arrivalString = rs.getString("arrivalString");
					String repairBeginStringPlan = rs.getString("repairBeginStringPlan");
					String repairBeginStringReal = rs.getString("repairBeginStringReal");
					String assignedWorker = rs.getString("assignedWorker");
					String problemDesc = rs.getString("problemDesc");
					String repairDesc = rs.getString("repairDesc");
					String status = rs.getString("status");
					String vehicleRepaired = rs.getString("vehicleRepaired");
					Double customerRepairCost = rs.getDouble("customerRepairCost");
					Double partsCost = rs.getDouble("customerRepairCost");
					Double wrkHourCost = rs.getDouble("customerRepairCost");
					int wrkHours = rs.getInt("wrkHours");
					return new Order(id, arrivalString, repairBeginStringPlan, repairBeginStringReal, assignedWorker,
							problemDesc, repairDesc, status, vehicleRepaired, customerRepairCost, partsCost,
							wrkHourCost, wrkHours);
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<Order> search(String phrase) {
		List<Order> Order = new ArrayList<>();
		try (Connection connection = DbUtil.getConn()) {
			try (PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM Orders WHERE name LIKE '%" + phrase + "%'")) {

				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String arrivalString = rs.getString("arrivalString");
					String repairBeginStringPlan = rs.getString("repairBeginStringPlan");
					String repairBeginStringReal = rs.getString("repairBeginStringReal");
					String assignedWorker = rs.getString("assignedWorker");
					String problemDesc = rs.getString("problemDesc");
					String repairDesc = rs.getString("repairDesc");
					String status = rs.getString("status");
					String vehicleRepaired = rs.getString("vehicleRepaired");
					Double customerRepairCost = rs.getDouble("customerRepairCost");
					Double partsCost = rs.getDouble("customerRepairCost");
					Double wrkHourCost = rs.getDouble("customerRepairCost");
					int wrkHours = rs.getInt("wrkHours");
					Order.add(new Order(id, arrivalString, repairBeginStringPlan, repairBeginStringReal, assignedWorker,
							problemDesc, repairDesc, status, vehicleRepaired, customerRepairCost, partsCost,
							wrkHourCost, wrkHours));
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Order;
	}
}