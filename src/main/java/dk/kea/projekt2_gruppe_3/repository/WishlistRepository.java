package dk.kea.projekt2_gruppe_3.repository;

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

    public void deleteWishlist(Wishlist wishlist) {
        String sql = "DELETE FROM wishList WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, wishlist.getId());

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
        String sql = "SELECT * FROM wishList WHERE id = ?";
        Wishlist wishlist = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    wishlist = new Wishlist();
                    wishlist.setId(resultSet.getInt("id"));
                    wishlist.setName(resultSet.getString("name"));
                    wishlist.setImg(resultSet.getString("img"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        return wishlist;
    }

}

