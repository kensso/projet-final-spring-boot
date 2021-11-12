package Dao;


import org.springframework.data.jpa.repository.JpaRepository;

import model.Product;

public interface Productrepository extends JpaRepository<Product, Long> {

}
