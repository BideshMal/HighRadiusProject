package com.highradius.implementation;

import com.highradius.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class  InvoiceDao {

    private List<Invoice> invoices;

    public InvoiceDao() {
        // Initialize the list of invoices
        invoices = new ArrayList<>();
    }

    public List<Invoice> getInvoices() {
        // Return the list of invoices
        return invoices;
    }

    public boolean insertInvoice(Invoice invoice) {
        // Perform the logic to insert the invoice into the data storage
        // Example: Adding the invoice to the list
        return invoices.add(invoice);
    }

    public boolean updateInvoice(int id, Invoice invoice) {
        // Perform the logic to update an existing invoice with the given ID
        // Example: Find the invoice by ID and update its attributes
        for (Invoice existingInvoice : invoices) {
            if (existingInvoice.getId() == id) {
                existingInvoice.setCustomerName(invoice.getCustomerName());
                existingInvoice.setInvoiceAmount(invoice.getInvoiceAmount());
                // Update other attributes as needed
                return true; // Return true if the update was successful
            }
        }
        return false; // Return false if no invoice with the given ID was found
    }

    public boolean deleteInvoice(int id) {
        // Perform the logic to delete the invoice with the given ID
        // Example: Find the invoice by ID and remove it from the list
        for (Invoice existingInvoice : invoices) {
            if (existingInvoice.getId() == id) {
                return invoices.remove(existingInvoice);
            }
        }
        return false; // Return false if no invoice with the given ID was found
    }
}



