package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
public class Product extends BaseEntity {
	@Column(length = 50, unique = true)
	private String name;
	private String description;
	private double price;
	@Column(name = "available_stock")
	private int availableStock;
	@Column(name = "expiry_date")
	private LocalDate expiryDate;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Category category;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long id , String name, String description, Category category, double price, int availableStock,
			LocalDate expiryDate) {
		super(id);
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.availableStock = availableStock;
		this.expiryDate = expiryDate;
	}
}
