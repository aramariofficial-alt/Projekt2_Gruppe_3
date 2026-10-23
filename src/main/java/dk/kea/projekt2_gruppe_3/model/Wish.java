package dk.kea.projekt2_gruppe_3.model;

public class Wish {
    int id;
    String name;
    String description;
    double price;
    String link;
    String category;
    String img;
    int wishlistId;



    public Wish(String name, String description, double price, String link, String category, String img, int wishlistId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.category = category;
        this.img = img;
        this.wishlistId = wishlistId;
    }

    public Wish(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }
}



