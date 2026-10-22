package dk.kea.projekt2_gruppe_3.model;

import java.util.ArrayList;

public class Wishlist {
    int id;
    String name;
    String img;
    ArrayList<Wish> wishes;

    public Wishlist(ArrayList<Wish> wishes, String img, String name, int id) {
        wishes = new ArrayList<>();
        this.wishes = wishes;
        this.img = img;
        this.name = name;
        this.id = id;
    }

    public Wishlist(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ArrayList<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(ArrayList<Wish> wishes) {
        this.wishes = wishes;
    }
}
