CREATE DATABASE hotel_management;
USE hotel_management;

CREATE TABLE rooms (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(50),
    price INT
);

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    room_id INT,
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);

CREATE TABLE menu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100),
    price INT
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    item_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (item_id) REFERENCES menu(id)
);

INSERT INTO rooms (room_type, price) VALUES
('Luxury', 5000),
('Deluxe', 3000);

INSERT INTO menu (item_name, price) VALUES
('Paneer Butter Masala', 250),
('Chicken Biryani', 300),
('Veg Thali', 200);
