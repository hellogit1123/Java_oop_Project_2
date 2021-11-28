package com.mycompany.pizzaapp;

public class CustomerData 
{
    private String name;
    private String phoneNumber;
    private String cardNumber;
    private String orderNumber;
    
    CustomerData(String name, String phoneNumber, String cardNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
    }
    CustomerData(){}
    
    public String getOrderNum()
    {
        String s = "";
        s = s+(this.name).substring(0,1);
        s = s+(this.phoneNumber).substring(0,2);
        s = s+(this.cardNumber).substring(0,2);
        return s;
    }
    public boolean checkName(String name)
    {
        if(name.equals(""))
        {
            this.emptyAll();
            return false;
        }
        this.name = name;
        return true;
    }
    public boolean checkPhone(String Number)
    {
        if(Number.length() != 10 || !Number.matches("[0-9]+"))
        {
            this.emptyAll();
            return false;
        }
        this.phoneNumber = phoneNumber;
        return true;
    }
    public boolean checkCard(String Number)
    {
        if(Number.length() != 16 || !Number.matches("[0-9]+"))
        {
            this.emptyAll();
            return false;
        }
        this.cardNumber = cardNumber;
        return true;    
    }
    
    public String getName()
    {
        return this.name;
    }
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    public String getCardNumber()
    {
        return this.cardNumber;
    }
    
    public String getAllinfo()
    {
        String info = "";
        info = info + this.name + " " + this.phoneNumber + " " + this.cardNumber;
        return info;
    }
    
    public void emptyAll()
    {
        this.name = "";
        this.phoneNumber = "";
        this.cardNumber = "";
    }
}
