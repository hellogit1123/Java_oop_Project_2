package com.mycompany.pizzaapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class txt_db 
{
    public void write(String info)
    {
        
    }
    
    public ArrayList read()
    {
        //System.out.println("I am in db read");
        ArrayList<Pizza> a = new ArrayList<Pizza>();
        int index = 0;
        Pizza p;
        
        while(index<=8)
        {
            String location = "";
            location = location + "pizzas/pizza" + String.valueOf(index) +".txt";
            //System.out.println(location);
            File file = new File(location);
            if(file.exists())
            {
                //System.out.println("im inside file exists");
                try {
                    //System.out.println("hello im in db");
                    Scanner input = new Scanner(file);
                    p = new Pizza();
                    p.setName(input.nextLine());
                    p.setSize(input.nextLine().charAt(0));
                    p.addToppings(input.nextLine());
                    p.addToppings(input.nextLine());
                    p.setSauce(input.nextLine());
                    p.setPrice(Double.valueOf(input.nextLine()));
                    a.add(p);
                    System.out.println(index);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(txt_db.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("File not found");
                }
            }
            index++;
        }
        //System.out.println(a.size());
        return a;
    }
}
