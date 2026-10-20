package dk.kea.projekt2_gruppe_3.service;

import org.springframework.stereotype.Service;

@Service
public class WishService {

    public String getImg(String category) {

        String img = null;

        if (category.equalsIgnoreCase("Electronics")) {
            img = "electronics.png";
        } else if (category.equalsIgnoreCase("Kitchen")) {
            img = "kitchen.png";
        } else if (category.equalsIgnoreCase("Clothing")) {
            img = "clothing.png";
        } else if (category.equalsIgnoreCase("Sports")) {
            img = "sports.png";
        } else if (category.equalsIgnoreCase("Books")) {
            img = "books.png";
        } else if (category.equalsIgnoreCase("Toys")) {
            img = "toys.png";
        } else if (category.equalsIgnoreCase("Other")) {
            img = "other.png";
        }
        return img;
    }
}