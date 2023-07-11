package com.highradius.model;

import java.util.Date;

public class Invoice {
    public int invoiceNumber;
    public String customerName;
    public double invoiceAmount;
    public String customerOrderID;
    public String salesOrg;
    public String distributionChannel;
    public String customerNumber;
    public String companyCode;
    public String orderCurrency;
    public double amountUSD;
    public String orderCreationDate;

    public Invoice(int invoiceNumber, String customerName, double invoiceAmount, String customerOrderID, String salesOrg,
                   String distributionChannel, String customerNumber, String companyCode, String orderCurrency,
                   double amountUSD, Date orderCreationDate) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.invoiceAmount = invoiceAmount;
        this.customerOrderID = customerOrderID;
        this.salesOrg = salesOrg;
        this.distributionChannel = distributionChannel;
        this.customerNumber = customerNumber;
        this.companyCode = companyCode;
        this.orderCurrency = orderCurrency;
        this.amountUSD = amountUSD;
        this.orderCreationDate = orderCreationDate;
    }

    // Add getter and setter methods for each attribute

    public Invoice(int invoiceNumber2, String customerName2, double invoiceAmount2, String customerOrderID2,
			String salesOrg2, String distributionChannel2, String customerNumber2, String companyCode2,
			String orderCurrency2, double amountUSD2, String orderCreationDate2) {
		// TODO Auto-generated constructor stub
	}

	public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getCustomerOrderID() {
        return customerOrderID;
    }

    public void setCustomerOrderID(String customerOrderID) {
        this.customerOrderID = customerOrderID;
    }

    public String getSalesOrg() {
        return salesOrg;
    }

    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    public String getDistributionChannel() {
        return distributionChannel;
    }

    public void setDistributionChannel(String distributionChannel) {
        this.distributionChannel = distributionChannel;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public double getAmountUSD() {
        return amountUSD;
    }

    public void setAmountUSD(double amountUSD) {
        this.amountUSD = amountUSD;
    }

    public String getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(Date orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }
}
