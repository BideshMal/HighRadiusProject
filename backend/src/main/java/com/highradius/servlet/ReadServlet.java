package com.highradius.servlet;

import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
        List<Invoice> invoices = invoiceDao.getInvoices();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>List of Invoices</h1>");
        out.println("<table>");
        out.println("<tr><th>Invoice Number</th><th>Customer Name</th><th>Invoice Amount</th></tr>");
        for (Invoice invoice : invoices) {
            out.println("<tr><td>" + invoice.getInvoiceNumber() + "</td><td>" +
                    invoice.getCustomerName() + "</td><td>" + invoice.getInvoiceAmount() + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }
}
