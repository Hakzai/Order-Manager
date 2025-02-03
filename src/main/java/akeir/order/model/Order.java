package akeir.order.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
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
	
	@Column(nullable = false)
	private String customerName;
	
	@ElementCollection
	@Column(nullable = false)
	private List<Product> items;
	
	private double total;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime registerDate;
	
	private LocalDateTime deliveryRequiredDate;
	
	private boolean isOrderReady;
	
	private boolean isOrderCheckedOut;
	
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

	public List<Product> getItems() 
	{
		return items;
	}

	public void setItems(List<Product> items) 
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
	
	public LocalDateTime getRegisterDate()
	{
		return registerDate;
	}
	
	public void setRegisterDate(LocalDateTime registerDate)
	{
		this.registerDate = registerDate;
	}
	
	public LocalDateTime getDeliveryRequiredDate()
	{
		return deliveryRequiredDate;
	}
	
	public void setDeliveryRequiredDate(LocalDateTime deliveryRequiredDate)
	{
		this.deliveryRequiredDate = deliveryRequiredDate;
	}

	public boolean isOrderReady() 
	{
		return isOrderReady;
	}

	public void setOrderReady(boolean isOrderReady) 
	{
		this.isOrderReady = isOrderReady;
	}

	public boolean isOrderCheckedOut() 
	{
		return isOrderCheckedOut;
	}

	public void setOrderCheckedOut(boolean isOrderCheckedOut) 
	{
		this.isOrderCheckedOut = isOrderCheckedOut;
	}
}
