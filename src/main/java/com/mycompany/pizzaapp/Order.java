package com.mycompany.pizzaapp;

import java.util.Date;

public class Order 
{
    private Cart cart;
    private CustomerData d;
    private double price;
    private String orderNumber;
    private Date date1;
    
    Order(){}
    
    public void setOrder(Cart c, CustomerData d)
    {
        this.cart = c;
        this.d = d;
        this.orderNumber = this.d.getOrderNum();
        date1 = new Date();
    }
    public Date getDate()
    {
        return this.date1;
    }
    public CustomerData getCustomerData()
    {
        return this.d;
    }
    public String getOrderNum()
    {
        return this.orderNumber;
    }
    public Cart getCart()
    {
        return this.cart;
    }
}
