package com.mycompany.pizzaapp;
import java.util.ArrayList;

public class Cart 
{
    private ArrayList<Pizza> cart = new ArrayList<Pizza>();
    private double totalPrice;
    
    public void insetPizza(Pizza p)
    {
        cart.add(p);
    }
   
    public boolean removePizza(String strNum)
    {
        try {
            double d = Double.parseDouble(strNum);
            int index = (int)d;
            if(index <= this.getSize()-1)
                cart.remove(index);
            else 
                return false;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public String getCurrentPizza()
    {
        int currPizza = cart.size()-1;
        String info = "";
        String PizzaName = cart.get(currPizza).getName();
        String toppings = cart.get(currPizza).getToppings();
        String sauce = cart.get(currPizza).getSauce();
        String price = String.valueOf(cart.get(currPizza).getPrice());

        info  = info + "Name: " + PizzaName + "\n" +
                       "Toppings Used: " + toppings + "\n" +
                       "Sauce Used: " + sauce + "\n" +
                       "Size: " + cart.get(currPizza).getSize() + "\n" +
                       "Price of this Pizza: " + price + "\n\n";
        return info;
    }
    public String getPizzaInfo()
    {
        String info = "";
        int count = 0;
        for(Pizza p: cart)
        {
            String PizzaName = p.getName();
            String toppings = p.getToppings();
            String sauce = p.getSauce();
            String price = String.valueOf(p.getPrice());
            
            info  = info + "Pizza_Number: " + String.valueOf(count) + "\n" +
                            "Name: " + PizzaName + "\n" +
                           "Toppings Used: " + toppings + "\n" +
                           "Sauce Used: " + sauce + "\n" +
                           "Size: " + p.getSize() + "\n" +
                           "Price of this Pizza: $" + price + "\n\n";
                           
            
            count++;
            
        }
        info = info + "\n\nTotal Price: $" + String.valueOf(this.getTotalPrice());
        return info;
    }
    public String getAllPizzaName()
    {
        String s = "";
        for(Pizza p:cart)
        {
            s = s + p.getName() + " ,";
        }
        return s;
    }
    public double getTotalPrice()
    {
        double pr = 0;
        for(Pizza p:cart)
        {
            pr += p.getPrice();
        }
        return pr;
    }
    public int getSize()
    {
        return cart.size();
    }
    public void emptyCart()
    {
        cart.clear();
    }
}