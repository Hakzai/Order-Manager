package akeir.order.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String customerName;
	
	@ElementCollection
	private List<String> items;
	
	private double total;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getCustomerName() 
	{
		return customerName;
	}

	public void setCustomerName(String customerName) {
		
		this.customerName = customerName;
	}

	public List<String> getItems() 
	{
		return items;
	}

	public void setItems(List<String> items) 
	{
		this.items = items;
	}

	public double getTotal() 
	{
		return total;
	}

	public void setTotal(double total) 
	{
		this.total = total;
	}
}
