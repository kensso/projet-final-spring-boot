package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Product implements Serializable{
	@Id
	@GeneratedValue
	private long id;
	
	private String designation;
	private double price;
	private int quantite;
	public Product() {
		super();
	}
	public Product(String designation, double price, int quantite) {
		super();
		
		this.designation = designation;
		this.price = price;
		this.quantite = quantite;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	

}
