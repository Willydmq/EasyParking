package com.EasyParking.O18_14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EasyParking.O18_14.model.Product;
import com.EasyParking.O18_14.model.User;

import org.springframework.data.domain.Sort;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByUser(User user, Sort sort);

	public Product findByUserAndId(User user, Integer id);
}