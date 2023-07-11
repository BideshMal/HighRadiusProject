package com.highradius.connection;

import com.highradius.model.Invoice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    public List<Invoice> invoices;

    public DatabaseConnection() {
        invoices = new ArrayList<>();
        Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String url="jdbc:mysql://localhost:3306/oap_h2h";
		String user="root";
		String password="Krishna680@";
		String sql="Select * from h2h_oap";
		try {
			//Load my driver for JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
			statement=connection.createStatement();
			//statement.execute(sql);
			//statement.executeUpdate(sql);
			System.out.println("Before..."+resultSet);
			resultSet=statement.executeQuery(sql);
			System.out.println("After..."+resultSet);
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
    }

    /**
     * Retrieves the list of invoices.
     *
     * @return The list of invoices
     */
    public List<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * Adds an invoice to the list.
     *
     * @param invoice The invoice to be added
     */
    public void addInvoice(Invoice invoice) {
        ((DatabaseConnection) invoices).addInvoice(invoice);
    }

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
