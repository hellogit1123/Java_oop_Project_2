package com.mycompany.pizzaapp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class premade_pizzas 
{
    private ArrayList<String> a = new ArrayList<String>();
    premade_pizzas()
    {
        try {
            this.load_data();
        } catch (FileNotFoundException ex) {
            System.out.println("load data didn't work");
            Logger.getLogger(premade_pizzas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void load_data() throws FileNotFoundException
    {
        //System.out.println("im in premade loaddata");
        database db = new txt_db();
        a = db.read();
        //System.out.println(a.size());
    }
    
    public ArrayList get_data()
    {    
        return this.a;
    }
}
