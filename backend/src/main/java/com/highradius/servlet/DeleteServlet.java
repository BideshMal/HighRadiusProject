package com.highradius.servlet;

import com.highradius.implementation.InvoiceDaoImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int invoiceNumber = Integer.parseInt(request.getParameter("invoiceNumber"));

        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
        invoiceDao.deleteInvoice(invoiceNumber);

        response.sendRedirect("read"); // Redirect to ReadServlet to display the updated list of invoices
    }
}
