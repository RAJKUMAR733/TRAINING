package org.example.service;

import org.example.model.Category;

import java.util.Scanner;

public class Implementation {
    public static Category takeInput()
    {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter valid input For Category:");
        System.out.println("1.Mobile");
        System.out.println("2.Laptop");
        System.out.println("3.TV");
        System.out.println("4.Refrigerator");
        try {
            int n =scn.nextInt();
            if(n==1)
            {
                return Category.Mobile;
            }
            else if(n==2)
            {
                return Category.Laptop;
            }
            else if(n==3)
            {
                return Category.TV;
            }
            else if(n==4)
            {
                return Category.Refrigerator;
            }
            else
                return takeInput();
        }
        catch (Exception e)
        {
            System.out.println("Enter a valid Input!");
            return takeInput();
        }
    }
}
