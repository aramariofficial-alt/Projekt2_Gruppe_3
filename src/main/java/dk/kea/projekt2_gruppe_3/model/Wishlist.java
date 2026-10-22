package dk.kea.projekt2_gruppe_3.model;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    int id;
    String name;
    String img;
    List<Wish> wishes;

    public Wishlist(String img, String name) {
        this.wishes = new ArrayList<>();
        this.img = img;
        this.name = name;
        this.id = id;
    }

    public Wishlist(){}


    public void addWish(Wish wish){
        wishes.add(wish);
    }
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

    public List<Wish> getWishes() {
        return wishes;
    }

}
