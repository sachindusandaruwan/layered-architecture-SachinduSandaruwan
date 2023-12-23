package com.example.layeredarchitecture.model;

import java.math.BigDecimal;

public class CustomerOrderDTO {
    private String customerId;
    private String customerName;
    private String orderId;
    private String localDate;
    //private BigDecimal orderTotal;

    public CustomerOrderDTO(String customerId, String customerName, String orderId, String localDate) {
        this.customerId=customerId;
        this.customerName=customerName;
        this.orderId=orderId;
        this.localDate=localDate;
    }

        public String getCustomerId(){
        return customerId;
        }
        public void setCustomerId(String customerId){
        this.customerId=customerId;
        }
        public String getCustomerName(){
        return  customerName;

        }
        public void setCustomerName(String customerName){
        this.customerName=customerName;
        }
    public String getOrderId(){
        return  orderId;

    }
    public void setOrderId(String orderId){
        this.orderId=orderId;
    }
    public String getLocalDate(){
        return localDate;
    }
    public void setLocalDate(String localDate){
        this.localDate=localDate;
    }

    }

