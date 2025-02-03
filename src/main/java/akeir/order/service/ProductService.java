package akeir.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import akeir.order.model.Order;
import akeir.order.model.Product;
import akeir.order.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private static ProductService instance;
	
	public ProductService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
		instance = this;
	}
	
	public static ProductService getInst() 
	{
		return instance;
	}
	
	public void setOrderRefIds(Order order)
	{
		for(Product product : order.getItems())
		{
			product.setOrderRefId(order.getId());
		}
	}
	
	public void saveProducts(Order order)
	{
		for(Product product : order.getItems())
		{
			productRepository.save(product);
		}
	}
	
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
}
