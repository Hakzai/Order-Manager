package akeir.order.service;

import org.springframework.stereotype.Service;

import akeir.order.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}
	
//	public void setOrderReference
}
