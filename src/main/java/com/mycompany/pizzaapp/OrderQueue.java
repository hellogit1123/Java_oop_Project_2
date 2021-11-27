package com.mycompany.pizzaapp;
import java.util.ArrayList;
import java.util.Date;

public class OrderQueue 
{
    private static ArrayList<Order> ongoing_order = new ArrayList<Order>();
    private static ArrayList<Order> readyForPickup_order = new ArrayList<Order>();
    
    public void insertOngoingOrder(Order o)
    {
        ongoing_order.add(o);
    }
    public String getOrderNum()
    {
        return ongoing_order.get(ongoing_order.size()-1).getOrderNum();
    }
    public void checkTime()
    {
        Date date2 = new Date();
        for(int i = 0;i<ongoing_order.size();i++)
        {
            Order o = ongoing_order.get(i);
            if(date2.getTime() - o.getDate().getTime() >= 10000)
            {
                readyForPickup_order.add(o);
                ongoing_order.remove(i);
            }
        }
    }
    public boolean removeOngoingOrder(String orderNum)
    {
        int index = 0;
        for(Order o:ongoing_order)
        {
            if(o.getOrderNum().equals(orderNum))
            {
                ongoing_order.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }
    
    public void insetPickup_order(Order o)
    {
        readyForPickup_order.add(o);
    }
    
    public String showOngoinOrder()
    {
        String s = "";
        if(ongoing_order.size() != 0)
        {
            for(int i = 0;i<ongoing_order.size();i++)
            {
                s = s + "\nCustomer Name: " + ongoing_order.get(i).getCustomerData().getName() + "\n";
                s = s + "Toal Pizzas: " + ongoing_order.get(i).getCart().getSize() + "\n";
                s = s+"Pizza Names: ";
                s = s + ongoing_order.get(i).getCart().getAllPizzaName();
                s = s+"\nTotal: $"+ String.valueOf(ongoing_order.get(i).getCart().getTotalPrice());
                s+="\n";
            }
        }else
            s += "Empty";
        s+="\n\n";
        return s;
    }
    public String showOrderReady()
    {
        String s = "";
        if(readyForPickup_order.size() != 0)
        {
            for(int i = 0;i<readyForPickup_order.size();i++)
            {
                s = s + "\nCustomer Name: " + readyForPickup_order.get(i).getCustomerData().getName() + "\n";
                s = s + "Toal Pizzas: " + readyForPickup_order.get(i).getCart().getSize() + "\n";
                s = s+"Pizza Names: ";
                s = s + readyForPickup_order.get(i).getCart().getAllPizzaName();
                s = s+"\nTotal: $"+ String.valueOf(readyForPickup_order.get(i).getCart().getTotalPrice());
                s+="\n";
            }            
        }else{
            s += "Empty";
        }
        s+="\n\n";
        return s;
    }
}
