package com.highradius.servlet;
import com.highradius.implementation.*;
import com.highradius.model.Invoice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
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
        
        InvoiceDao dao=null;
        dao = new InvoiceDaoImpl;
      boolean inserted =  dao.insertInvoice(invoice);
      
      if(inserted) {
    	  response.getWriter().append("Added Successfully");
      }else {
    	  response.getWriter().append("unable to insert");
      }
        
        Invoice invoice = new Invoice(invoiceNumber, customerName, invoiceAmount, customerOrderID, salesOrg,
                distributionChannel, customerNumber, companyCode, orderCurrency, amountUSD, orderCreationDate);

        InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl();
        invoiceDao.insertInvoice(invoice);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Invoice added successfully!</h1>");
        out.println("</body></html>");
    }

    public static void main(String[] args) {
        AddServlet addServlet = new AddServlet();
        
    }
}
