package com.mycompany.pizzaapp;

public class main 
{
    public static void main(String[] args) //throws FileNotFoundException 
    {     
        System.out.println("I am in main");
        Cart cart = new Cart();
        _Connection conn = new _Connection();
        
        __Welcome w = new __Welcome(conn);
        w.show();
    }
}

