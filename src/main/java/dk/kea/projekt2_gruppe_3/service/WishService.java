package dk.kea.projekt2_gruppe_3.service;
org.springframework.stereotype.Service;



public class WishService {
    @Service
    public class WishService {

        public String getImg (String Category) {

            String img = null;

            if (Category.contains("Electronics")) {
                img = "xxxx.jpg";
            } else if (Category.contains("Kitchen")) {
                img = "xxx.jpg";
            } else if (Category.contains("Clothing")) {
                img = "xxx.jpg";
            } else if (Category.contains("Sports")) {
                img = "xxx.jpg";
            } else if (Category.contains("Books")) {
                img = "xxx.jpg";
            } else if (Category.contains("Toys")) {
                img = "xxx.jpg";
            } else if (Category.contains("Other")){

        }
                return img;



        }
    }
}