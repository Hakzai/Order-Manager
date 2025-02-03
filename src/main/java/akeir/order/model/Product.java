package akeir.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private double unitPrice;
	
	@Column(nullable = false)
	private Long orderedQuantity;
	
	private Long orderReferenceId;

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

	public Long getOrderRef() 
	{
		return orderReferenceId;
	}

	public void setOrderRefId(Long orderReferenceId) 
	{
		this.orderReferenceId = orderReferenceId;
	}
	
	@Override
	public String toString()
	{
		return "Product: " + this.name + "__" + this.orderedQuantity + "__" + this.unitPrice;
	}
}
