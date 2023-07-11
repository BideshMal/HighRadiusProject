package com.highradius.servlet;

import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int invoiceNumber = Integer.parseInt(request.getParameter("invoiceNumber"));
        String customerName = request.getParameter("customerName");
        double invoiceAmount = Double.parseDouble(request.getParameter("invoiceAmount"));
        String customerOrderID = request.getParameter("customerOrderID");
        String salesOrg = request.getParameter("salesOrg");
        String distributionChannel = request.getParameter("distributionChannel");
        String customerNumber = request.getParameter("customerNumber");
        String companyCode = request.getParameter("companyCode");
        String orderCurrency = request.getParameter("orderCurrency");
        double amountUSD = Double.parseDouble(request.getParameter("amountUSD"));
        String orderCreationDate = request.getParameter("orderCreationDate");

        Invoice invoice = new Invoice(invoiceNumber, customerName, invoiceAmount, customerOrderID, salesOrg,
                distributionChannel, customerNumber, companyCode, orderCurrency, amountUSD, orderCreationDate);
        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
        invoiceDao.updateInvoice(invoiceNumber, invoice);

        response.sendRedirect("read"); // Redirect to ReadServlet to display the updated list of invoices
    }
}
