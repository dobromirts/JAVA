package com.softuni.productshop.repositories;

import com.softuni.productshop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.productsToSell.size > 0 ORDER BY u.firstName, u.lastName")
    List<User> findByProductsToSellIsNotEmpty();
}
