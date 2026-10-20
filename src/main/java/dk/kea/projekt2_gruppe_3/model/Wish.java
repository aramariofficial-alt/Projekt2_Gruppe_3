package dk.kea.projekt2_gruppe_3.model;

public class Wish {
        String name;
        String description;
        double price;
        String link;
        String category;
        String image;
        int wishList_id;


        public Wish(String name, String description, double price, String link, String category, String image, int wishList_id) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.link = link;
            this.category = category;
            this.image = image;
            this.wishList_id = wishList_id;
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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getWishList_id() {
            return wishList_id;
        }

        public void setWishList_id(int wishList_id) {
            this.wishList_id = wishList_id;
        }
    }



