package com.mycompany.pizzaapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class txt_db implements database 
{
    public void write(String info)
    {
        
    }
    
    public ArrayList read()
    {
        //System.out.println("I am in db read");
        ArrayList<String> s = new ArrayList<String>();
        int index = 0;
        
        while(index<=8)
        {
            String location = "";
            location = location + "pizzas/pizza" + String.valueOf(index) +".txt";
            File file = new File(location);
            if(file.exists())
            {
                String info  = "";
                try {
                    //System.out.println("hello im in db");
                    Scanner input = new Scanner(file);
                    info = info + input.nextLine()+ " ";
                    info = info + input.nextLine()+ " ";
                    info = info + input.nextLine()+ " ";
                    info = info + input.nextLine()+ " ";
                    info = info + input.nextLine()+ " ";
                    info = info + input.nextLine()+ " ";
                    s.add(info);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(txt_db.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("File not found");
                }
            }
            index++;
        }
        return s;
    }
}
