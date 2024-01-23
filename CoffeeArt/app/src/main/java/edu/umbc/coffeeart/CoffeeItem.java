package edu.umbc.coffeeart;


public class CoffeeItem {

    private String name;
    private int art;

    public CoffeeItem(String name, int art) {
        this.name = name;
        this.art = art;
    }

    public String getName() {
        return name;
    }

    public int getArt() {
        return art;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArt(int art) {
        this.art = art;
    }
}
