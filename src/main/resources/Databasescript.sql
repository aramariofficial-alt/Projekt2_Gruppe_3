
-- Script 2: init.sql
-- Opretter og initialiserer projektets database.

DROP DATABASE IF EXISTS projekt2_gruppe_3_db;

CREATE DATABASE projekt2_gruppe_3_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE projekt2_gruppe_3_db;


-- Tabel til ønskelister
CREATE TABLE wishlist (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          img VARCHAR(255)
);


-- Tabel til ønsker
CREATE TABLE wish (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      description VARCHAR(100) NOT NULL,
                      price DOUBLE NOT NULL,
                      link VARCHAR(100) NOT NULL,
                      category VARCHAR(50) NOT NULL,
                      img VARCHAR(255),
                      wishlist_id INT NOT NULL,

                      FOREIGN KEY (wishlist_id)
                          REFERENCES wishlist(id)
                            ON DELETE CASCADE
);


-- Eksempeldata til ønskelister
INSERT INTO wishlist (name) VALUES
                                ('JuleØnsker'),
                                ('FødselsdagsØnsker');


-- Eksempeldata til ønsker
INSERT INTO wish (
    name,
    description,
    price,
    link,
    category,
    img,
    wishlist_id
) VALUES
      (
          'PlayStation 5',
          'Sonys nyeste spillekonsol',
          4999.00,
          'https://www.pricerunner.dk',
          'Electronics',
          'electronics.png',
          1
      ),
      (
          'AirPods Pro',
          'Trådløse høretelefoner med noise cancelling',
          1899.00,
          'https://www.apple.com',
          'Electronics',
          'electronics.png',
          1
      ),
      (
          'Lego Technic',
          'Lego sæt til voksne',
          799.00,
          'https://www.lego.com',
          'Toys',
          'toys.png',
          1
      ),
      (
          'Nike Air Max',
          'Løbesko i sort',
          1199.00,
          'https://www.nike.com',
          'Clothing',
          'clothing.png',
          2
      ),
      (
          'Kogebog',
          'Vegetarisk kogebog af Ottolenghi',
          299.00,
          'https://www.saxo.com',
          'Books',
          'books.png',
          2
      ),
      (
          'Kaffemaskine',
          'Automatisk espressomaskine',
          2499.00,
          'https://www.elgiganten.dk',
          'Kitchen',
          'kitchen.png',
          2
      );

