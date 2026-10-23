package dk.kea.projekt2_gruppe_3.repository;

import dk.kea.projekt2_gruppe_3.model.Wish;
import dk.kea.projekt2_gruppe_3.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishlistRepository {

    @Autowired
    private DataSource dataSource;

    public void deleteWishlist(int id) {
        String sql = "DELETE FROM wishList WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void createWishlist(Wishlist wishlist) {
        String sql = "INSERT INTO wishList (name,img) VALUES (?,?)"; //opretter et nyt row i wishList

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, wishlist.getName());
            statement.setString(2, wishlist.getImg());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public List<Wishlist> getAllWishlists() {
        List<Wishlist> wishlists = new ArrayList<>();
        String sql = "SELECT * FROM wishList";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Wishlist wishlist = new Wishlist();
                wishlist.setId(resultSet.getInt("id"));
                wishlist.setName(resultSet.getString("name"));
                wishlist.setImg(resultSet.getString("img"));

                wishlists.add(wishlist);
            }

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return wishlists;

    }

    public Wishlist getWishlistById(int id) {
        String sqlWishlist = "SELECT * FROM wishList WHERE id = ?";
        String sqlWishes = "SELECT * FROM wish WHERE wishList_id = ?";
        Wishlist wishlist = null;

        try (Connection connection = dataSource.getConnection()) {

            // 1. Hent selve ønskelisten
            try (PreparedStatement statement = connection.prepareStatement(sqlWishlist)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        wishlist = new Wishlist();
                        wishlist.setId(resultSet.getInt("id"));
                        wishlist.setName(resultSet.getString("name"));
                        wishlist.setImg(resultSet.getString("img"));
                    }
                }
            }

            // 2. Hvis ønskelisten findes, hent dens ønsker og tilføj dem
            if (wishlist != null) {
                try (PreparedStatement statement = connection.prepareStatement(sqlWishes)) {
                    statement.setInt(1, id);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            Wish wish = new Wish();
                            wish.setId(resultSet.getInt("id"));
                            wish.setName(resultSet.getString("name"));
                            wish.setDescription(resultSet.getString("description"));
                            wish.setPrice(resultSet.getDouble("price"));
                            wish.setLink(resultSet.getString("link"));
                            wish.setCategory(resultSet.getString("category"));
                            wish.setImg(resultSet.getString("img"));
                            wish.setWishListId(resultSet.getInt("wishList_id"));

                            wishlist.addWish(wish); // Tilføjer ønsket til listen
                        }
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching wishlist with wishes");
            e.printStackTrace();
        }

        return wishlist;
    }

}

