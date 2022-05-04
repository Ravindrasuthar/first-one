package com.project.SportyShoes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SportyShoes.entity.Product;
import com.project.SportyShoes.jdbc.ProductRepository;
@Service
@Transactional
public class ProductService {
@Autowired
public ProductRepository prodrepo;
public List<Product> listAll()
{
return prodrepo.findAll();
}
public void save(Product product)
{
prodrepo.save(product);
}
public Product get(long id)
{
return prodrepo.findById(id).get();
}
public void delete(long id)
{
prodrepo.deleteById(id);
}
}