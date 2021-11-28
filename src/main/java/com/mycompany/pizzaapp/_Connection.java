package com.mycompany.pizzaapp;
import java.util.ArrayList;
import java.util.Scanner;

public class _Connection 
{
    Scanner input = new Scanner(System.in);
    private Cart cart;
    private CustomerData customerD;
    private Order o;
    private OrderQueue oq;
    private Pizza p;
    private premade_pizzas pre;
    private database d = new txt_db();
    
    _Connection(Cart c) //throws FileNotFoundException
    {
        this.cart = c;
        this.customerD = new CustomerData();
        this.o = new Order();
        this.oq = new OrderQueue();
        this.pre = new premade_pizzas();
    }
    public boolean addCustomPizza(char size, ArrayList<String> toppings, String sauce, String name)
    {
        if(cart.getSize() < 10)
        {
            p = new Pizza(size, toppings, sauce, name);
            cart.insetPizza(p);
            return true;
        }
        return false;   
    }
    public boolean addPremadePizza(Pizza p)
    {
        if(cart.getSize() < 10)
        {
            cart.insetPizza(p);
            return true;
        }
        return false;
    }
    public void newCustomerData(String name, String phone, String card)
    {
        customerD = new CustomerData(name, phone, card);
        o.setOrder(cart, customerD);
        oq.insertOngoingOrder(o);
        
        String content = "-------------------------------------------------------------------\n";
        content += "CustomerData: ";
        content+= customerD.getAllinfo() +"\n\n";
        content += "Orders : \n"+cart.getPizzaInfo();
        content += "\n-------------------------------------------------------------------\n";
        System.out.println(content);
        d.write(content);
    }
    public boolean checkName(String name)
    {
        return this.customerD.checkName(name);
    }
    public boolean checkPhone(String Number)
    {
        return this.customerD.checkPhone(Number);
    }
    public boolean checkCard(String Number)
    {
        return this.customerD.checkCard(Number);
    }
    public String getPizzaInfo()
    {
        return this.cart.getPizzaInfo();
    }
    public boolean removePizza(String strNum)
    {
        return this.cart.removePizza(strNum);
    }
    public int getSize()
    {
        return this.cart.getSize();
    }
    public void checkTime()
    {
        this.oq.checkTime();
    }
    public boolean removeOngoingOrder(String orderNum)
    {
        return this.oq.removeOngoingOrder(orderNum);
    }
    public String getOrderNum()
    {
        return this.oq.getOrderNum();
    }
    public String showOngoinOrder()
    {
        return this.oq.showOngoinOrder();
    }
    public String showOrderReady()
    {
        return this.oq.showOrderReady();
    }
}
