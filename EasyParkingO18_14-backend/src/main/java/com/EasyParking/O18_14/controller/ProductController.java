package com.EasyParking.O18_14.controller;

import java.util.HashMap;
import java.util.Map;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.EasyParking.O18_14.model.Product;
import com.EasyParking.O18_14.model.User;
import com.EasyParking.O18_14.repository.ProductRepository;
import com.EasyParking.O18_14.service.UserService;

import java.security.Principal;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> listProducts(Principal principal) {
        String username = principal.getName();
        User currentUser = userService.getUser(username);
        List<Product> products = productRepository.findByUser(currentUser, Sort.by(Sort.Direction.ASC, "createdAt"));
        Map<String, Object> response = new HashMap<>();
        response.put("data",products);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        
    }
    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> list(){
        List<Product> productos = productRepository.findAll();
        return new ResponseEntity<List<Product>>(productos,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveProduct(@RequestBody Product product,Principal principal) {
        Map<String, String> response  = new  HashMap<>();
        String username = principal.getName();
        User currentUser = userService.getUser(username);
        if (product == null){
            response.put("message", "bad request");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
        }
        if (product.getName() == null){
            response.put("message", "bad request");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.BAD_REQUEST);
        }
        product.setUser(currentUser);
        productRepository.save(product);
        response.put("message", "product created");

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Product>> getProduct(@PathVariable("id") Integer id,Principal principal) {
        Map<String, Product> response  = new  HashMap<>();
        String username = principal.getName();
        User currentUser = userService.getUser(username);
        Product product = productRepository.findByUserAndId(currentUser, id);
        if (product == null){
            response.put("data", null);
            return new ResponseEntity<Map<String, Product>>(response, HttpStatus.NOT_FOUND);
        }
        response.put("data", product);
        return new ResponseEntity<Map<String, Product>>(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}/remove")
    public ResponseEntity<Map<String, String>> removeProduct(@PathVariable("id") Integer id, Principal principal) {
        Map<String, String> response  = new  HashMap<>();
        String username = principal.getName();
        User currentUser = userService.getUser(username);
        Product product = productRepository.findByUserAndId(currentUser, id);
        if (product == null){
            response.put("message", "not found");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        productRepository.delete(product);
        response.put("message", "product deleted");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateProduct(@PathVariable("id") Integer id,@RequestBody Product productUpdate,Principal principal) {
        Map<String, String> response  = new  HashMap<>();
        String username = principal.getName();
        User currentUser = userService.getUser(username);
        Product product = productRepository.findByUserAndId(currentUser, id);
        if (product == null){
            response.put("message", "not found");
            return new ResponseEntity<Map<String, String>>(response, HttpStatus.NOT_FOUND);
        }
        product.setName(productUpdate.getName());
        product.setPrice(productUpdate.getPrice());
        productRepository.save(product);

        response.put("message", "product updated");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }


}
