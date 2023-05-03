package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    List<Item> items;

    public ItemList()
    {
        items=new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }
}
