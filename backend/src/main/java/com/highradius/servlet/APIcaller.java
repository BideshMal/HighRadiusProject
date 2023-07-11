package com.highradius.servlet;
import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class APIcaller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Read the JSON payload from the request body
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        Invoice invoice = gson.fromJson(reader, Invoice.class);

        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
        invoiceDao.insertInvoice(invoice);

        response.setContentType("application/json");
        response.getWriter().write("Invoice added successfully!");
    }
}
