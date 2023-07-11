import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataLoadingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create an instance of the InvoiceDao implementation
        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();

        // Retrieve the list of invoices using the getInvoices method
        List<Invoice> invoices = invoiceDao.getInvoices();

        // Set the response content type
        response.setContentType("text/plain");
        
        Gson gson = new Gson();
        String json = gson.fromJson(invoices);
        
        // Write the invoices data to the response
        for (Invoice invoice : invoices) {
            response.getWriter().write("Customer Order ID: " + invoice.getCustomerOrderID() + "\n");
            response.getWriter().write("Sales Org: " + invoice.getSalesOrg() + "\n");
            response.getWriter().write("Distribution Channel: " + invoice.getDistributionChannel() + "\n");
            response.getWriter().write("Customer Number: " + invoice.getCustomerNumber() + "\n");
            response.getWriter().write("Company Code: " + invoice.getCompanyCode() + "\n");
            response.getWriter().write("Order Currency: " + invoice.getOrderCurrency() + "\n");
            response.getWriter().write("Amount in USD: " + invoice.getAmountUSD() + "\n");
            response.getWriter().write("Order Creation Date: " + invoice.getOrderCreationDate() + "\n");
            response.getWriter().write("-----------------------------------\n");
        }
    }
}
