package dk.kea.projekt2_gruppe_3.repository;

import dk.kea.projekt2_gruppe_3.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class WishRepository {
    @Autowired
    private DataSource dataSource;

    public void createWish(Wish wish) {
        String sql = "INSERT INTO wish (name, description, price, link, category, img, wishList_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            setWishParameters(wish, statement);
            statement.setInt(7, wish.getWishListId());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error creating wish");
            e.printStackTrace();
        }
    }


    public void updateWish(Wish wish) {
        String sql = "UPDATE wish SET name = ?, description = ?, price = ?, link = ?, category = ?, img = ? where id = ?";
        try (Connection connection = dataSource.getConnection(); //etablerer forbindelse til databasen
             PreparedStatement statement = connection.prepareStatement(sql)) { //gemmer en foreberedt sql-query i et statement objekt

            setWishParameters(wish, statement);
            statement.setInt(7, wish.getId());

            statement.executeUpdate();
            //Tager data fra fra java-objekter og opdaterer rows i data-tabellen
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    private void setWishParameters(Wish wish, PreparedStatement statement) throws SQLException {
        statement.setString(1, wish.getName()); //udfylder placeholder 1
        statement.setString(2, wish.getDescription());
        statement.setDouble(3, wish.getPrice());
        statement.setString(4, wish.getLink());
        statement.setString(5, wish.getCategory());
        statement.setString(6, wish.getImg());
    }


    public void deleteWish(int id) {
        String sql = "DELETE FROM wish WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1,  id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }


    public Wish findWishById(int id) {
        String sql = "SELECT * FROM wish WHERE id = ?";
        Wish wish = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    wish = new Wish();
                    wish.setId(resultSet.getInt("id"));
                    wish.setName(resultSet.getString("name"));
                    wish.setDescription(resultSet.getString("description"));
                    wish.setPrice(resultSet.getDouble("price"));
                    wish.setLink(resultSet.getString("link"));
                    wish.setCategory(resultSet.getString("category"));
                    wish.setImg(resultSet.getString("img"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error finding wish by id");
            e.printStackTrace();
        }

        return wish; // Returnerer ønsket, eller null hvis det ikke blev fundet
    }
}
