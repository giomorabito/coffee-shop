package com.example.coffeeshop.models;

public class Item {
    private String name;
    private String image;
    private double price;
    private int quantity;
    private String customizations;
    
    public Item(){
        
    }
    
    public Item(String name, double price, int quantity, String customizations){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.customizations = customizations;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCustomizations() {
        return customizations;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
