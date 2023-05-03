package org.example.model;



public class Item {
    private String id;
    private String name;
    private Category category;
    private boolean warranty;
    public Item(String id, String name, Category category, boolean warranty) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.warranty = warranty;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isWarranty() {
        return warranty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", warranty=" + warranty +
                '}';
    }
}
