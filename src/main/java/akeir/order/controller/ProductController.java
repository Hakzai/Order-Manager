package akeir.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import akeir.order.model.Product;
import akeir.order.service.ProductService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostConstruct
	public void init()
	{
		System.out.println("🚀 ProductController foi carregado!");
	}
	
	@GetMapping
	public String testEndpoint()
	{
		return "Test Product Service :: Product service is running!";
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		return ResponseEntity.ok(productService.getAllProducts());
	}
}
