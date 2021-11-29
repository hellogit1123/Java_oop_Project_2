package com.mycompany.pizzaapp;
import java.util.ArrayList;

public class Pizza 
{
    private char size;
    private ArrayList<String> toppings = new ArrayList<String>();
    private double price = 0;
    private String sauce;
    private String pizzaName;
    private Price p = new Price();
    
    Pizza(){}
    Pizza(char size, ArrayList<String> toppings, String sauce, String name)
    {
        this.pizzaName = name;
        this.sauce = sauce;
        this.setSize(size);
        for(String t:toppings)
        {
            this.addToppings(t);
        }
    }
    Pizza(char size, ArrayList<String> toppings, String sauce, String name, double price)
    {
        this.pizzaName = name;
        this.sauce = sauce;
        this.price = price;
        this.setSize(size);
        this.toppings = toppings;
    }
    public String getSize()
    {
        if(this.size == 's')
            return "Small";
        else if(this.size == 'm')
            return "Medium";
        else 
            return "Large";
    }
    public String pizzaInfo()
    {
        String s = "";
        s = s+this.pizzaName+"\n";
        s = s+this.sauce+" Sauce\n";
        s = s+this.toppings.get(0) + "\n";
        s = s+this.toppings.get(1) +"\n";
        s = s+"$"+this.price+"\n";
        return s;
    }
    public String getName()
    {
        return this.pizzaName;
    }
    
    public String getToppings()
    {
        String allTopping = "";
        for(String i:toppings)
        {
            allTopping = allTopping + i + " ";
        }
        return allTopping;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public String getSauce()
    {
        return this.sauce;
    }
    public void addToppings(String topping)
    {
        this.price += p.getPrice(topping); 
        toppings.add(topping);
    }
    public void setName(String name)
    {
        this.pizzaName = name;
    }
    public void setSauce(String sauce)
    {
        this.sauce = sauce;
    }
    public void setPrice(double d)
    {
        this.price = d;
    }
    public void setSize(char s)
    {
        this.price += p.getPrice(Character.toString(s));
        this.size = s;
    }
}
