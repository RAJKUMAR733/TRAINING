package org.example;

import org.example.model.Category;
import org.example.model.Item;
import org.example.model.ItemList;
import org.example.service.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[]args)
    {
        ItemList itemList=new ItemList();
        itemList.getItems().add(new Item("1","IPHONE 14", Category.Mobile,true));
        itemList.getItems().add(new Item("2","Samsung S22 ultra",Category.Mobile,false));
        itemList.getItems().add(new Item("3","Dell Inspiron 5000",Category.Laptop,true));
        itemList.getItems().add(new Item("4","Asus ROG",Category.Laptop,false));
        itemList.getItems().add(new Item("5","Sony",Category.TV,true));
        itemList.getItems().add(new Item("6","Samsung",Category.TV,false));
        itemList.getItems().add(new Item("7","Lg",Category.Refrigerator,true));
        itemList.getItems().add(new Item("8","Samsung",Category.Refrigerator,false));

        Category required=Implementation.takeInput();

        Predicate<Item>itemWithWarranty=(item)->item.isWarranty()==true&&required==item.getCategory();
        Predicate<Item>itemWithoutWarranty=(item)-> item.isWarranty()==false&&required==item.getCategory();


        Consumer<List<Item>>printItems=System.out::println;

        List<Item>listOfItemsWithWarranty=itemList.getItems().stream().filter(itemWithWarranty).collect(Collectors.toList());
        List<Item>listOfItemsWithoutWarranty=itemList.getItems().stream().filter(itemWithoutWarranty).collect(Collectors.toList());

        List<List<Item>>print=new ArrayList<>(List.of(listOfItemsWithWarranty,listOfItemsWithoutWarranty));

        print.forEach(printItems);
    }
}