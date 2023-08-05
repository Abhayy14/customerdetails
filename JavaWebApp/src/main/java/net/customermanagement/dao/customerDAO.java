package net.customermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.customermanagement.model.customer;


public class customerDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Sabhay137@";

	private static final String INSERT_USERS_SQL = "INSERT INTO customer" + "  (First_name,LAst_name, Address, City, State, Email, Country, phone) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USERS_BY_ID = "select id,Firsts_name,Last_name,Address,City,State,Email,Country,phone from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users"; 
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set First_name = ?,Last_name = ?,Address = ?,City = ?,State = ?,Email= ?, Country =?,phone = ? where id = ?;";

	public customerDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertcustomer(customer customer) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, customer.getFirst_name());
			preparedStatement.setString(2, customer.getLast_name());
			preparedStatement.setString(3, customer.getAddress());
			preparedStatement.setString(4, customer.getCity());
			preparedStatement.setString(5, customer.getState());
			preparedStatement.setString(6, customer.getEmail());
			preparedStatement.setString(7, customer.getCountry());
			preparedStatement.setInt(8, customer.getphone());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public customer selectcustomer(int id) {
		customer customer = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String First_name = rs.getString("First_name");
				String Last_name = rs.getString("Last_name");
				String Address = rs.getString("Address");
				String City = rs.getString("city");
				String State = rs.getString("State");
				String Email = rs.getString("Email");
				String country = rs.getString("Country");
				customer = new customer(id, First_name, Last_name, Address, City, State,  Email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return customer;
	}

	public  List<customer> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<customer> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String First_name = rs.getString("First_name");
				String Last_name = rs.getString("Last_name");
				String Address = rs.getString("Address");
				String City = rs.getString("City");
				String State = rs.getString("State");
				String Email = rs.getString("Email");
				String Country = rs.getString("Country");
				
				users.add(new customer(id, First_name, Last_name, Address, City, State,  Email, Country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(customer customer) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, customer.getFirst_name());
			statement.setString(2, customer.getLast_name());
			statement.setString(3, customer.getAddress());
			statement.setString(4, customer.getCity());
			statement.setString(5, customer.getState());
			statement.setString(6, customer.getEmail());
			statement.setString(7, customer.getCountry());
			statement.setInt(8, customer.getphone());
			statement.setInt(9, customer.getId());
 
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}

