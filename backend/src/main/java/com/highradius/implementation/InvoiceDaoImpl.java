package com.highradius.implementation;

import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {
	public List<Invoice> getInvoice() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Invoice> invoices = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM invoice";
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int invoiceNumber = resultSet.getInt("invoice_number");
                String customerName = resultSet.getString("customer_name");
                double invoiceAmount = resultSet.getDouble("invoice_amount");
                String customerOrderID = resultSet.getString("customer_order_id");
                String salesOrg = resultSet.getString("sales_org");
                String distributionChannel = resultSet.getString("distribution_channel");
                String customerNumber = resultSet.getString("customer_number");
                String companyCode = resultSet.getString("company_code");
                String orderCurrency = resultSet.getString("order_currency");
                double amountUSD = resultSet.getDouble("amount_usd");
                String orderCreationDate = resultSet.getString("order_creation_date");

                Invoice invoice = new Invoice(invoiceNumber, customerName, invoiceAmount, customerOrderID, salesOrg,
                        distributionChannel, customerNumber, companyCode, orderCurrency, amountUSD, orderCreationDate);

                invoices.add(invoice);
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
return invoices;
        
    }
    public boolean insertInvoice(Invoice invoice) {
        Connection connection = null;
        PreparedStatement statement = null;
        int count=0;
        try {
            connection = DatabaseConnection.getConnection();

            String sql = "INSERT INTO invoice (invoice_number, customer_name, invoice_amount, customer_order_id, " +
                    "sales_org, distribution_channel, customer_number, company_code, order_currency, amount_usd, " +
                    "order_creation_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, invoice.getInvoiceNumber());
            statement.setString(2, invoice.getCustomerName());
            statement.setDouble(3, invoice.getInvoiceAmount());
            statement.setString(4, invoice.getCustomerOrderID());
            statement.setString(5, invoice.getSalesOrg());
            statement.setString(6, invoice.getDistributionChannel());
            statement.setString(7, invoice.getCustomerNumber());
            statement.setString(8, invoice.getCompanyCode());
            statement.setString(9, invoice.getOrderCurrency());
            statement.setDouble(10, invoice.getAmountUSD());
            statement.setString(11, invoice.getOrderCreationDate());
int insert = statement.executeUpdate();
            statement.executeUpdate();
         count=insert;   
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
        	
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(count>0) {
        	return true;
        }else {
        	return false;
        }
    }
	public List<Invoice> getInvoices() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean updateInvoice(int id, Invoice invoice) {
		
		return true;
		// TODO Auto-generated method stub
		
	}
	
	public boolean deleteInvoice(int id) {
		return true;
		// TODO Auto-generated method stub
		
	}
}
