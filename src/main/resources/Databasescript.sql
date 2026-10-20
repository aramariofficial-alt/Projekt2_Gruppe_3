
-- Script 2: init.sql
-- Opretter og initialiserer projektets database.

DROP DATABASE IF EXISTS projekt2_gruppe_3_db;

CREATE DATABASE projekt2_gruppe_3_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE projekt2_gruppe_3_db;


-- Tabel til ønskelister
CREATE TABLE wishList (
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
                      wishList_id INT NOT NULL,

                      FOREIGN KEY (wishList_id)
                          REFERENCES wishList(id)
);


-- Eksempeldata til ønskelister
INSERT INTO wishList (name) VALUES
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
    wishList_id
) VALUES
      (
          'PlayStation 5',
          'Sonys nyeste spillekonsol',
          4999.00,
          'https://www.pricerunner.dk',
          'Gaming',
          'gaming.jpg',
          1
      ),
      (
          'AirPods Pro',
          'Trådløse høretelefoner med noise cancelling',
          1899.00,
          'https://www.apple.com',
          'Electronics',
          'electronics.jpg',
          1
      ),
      (
          'Lego Technic',
          'Lego sæt til voksne',
          799.00,
          'https://www.lego.com',
          'Toys',
          'toys.jpg',
          1
      ),
      (
          'Nike Air Max',
          'Løbesko i sort',
          1199.00,
          'https://www.nike.com',
          'Clothing',
          'clothing.jpg',
          2
      ),
      (
          'Kogebog',
          'Vegetarisk kogebog af Ottolenghi',
          299.00,
          'https://www.saxo.com',
          'Books',
          'books.jpg',
          2
      ),
      (
          'Kaffemaskine',
          'Automatisk espressomaskine',
          2499.00,
          'https://www.elgiganten.dk',
          'Kitchen',
          'kitchen.jpg',
          2
      );

