package Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Product;
@Repository
public interface Productrepository extends JpaRepository<Product, Long> {

}
