package com.example.modelclass.Model;

public class Cars {

  private String model;
  private String price;

     public  Cars(){


     }
    public Cars(String model, String price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
