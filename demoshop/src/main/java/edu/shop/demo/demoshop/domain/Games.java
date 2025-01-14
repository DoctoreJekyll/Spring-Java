package edu.shop.demo.demoshop.domain;


public class Games {

    private String name;
    private String duration;
    private Integer price;

    public Games(String name, String duration, Integer price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public Games()
    {

    }


    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
