package akeir.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private double unitPrice;
	
	private Long orderedQuantity;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order orderReference;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public double getUnitPrice() 
	{
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) 
	{
		this.unitPrice = unitPrice;
	}
	
	public Long getOrderedQuantity() 
	{
		return orderedQuantity;
	}
	
	public void setOrderedQuantity(Long orderedQuantity) 
	{
		this.orderedQuantity = orderedQuantity;
	}

	public Order getOrderRef() 
	{
		return orderReference;
	}

	public void setOrderRefId(Order orderReference) 
	{
		this.orderReference = orderReference;
	}
	
	@Override
	public String toString()
	{
		return "Product: " + this.name + "__" + this.orderedQuantity + "__" + this.unitPrice;
	}
}
