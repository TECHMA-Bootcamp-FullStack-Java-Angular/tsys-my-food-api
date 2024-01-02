package com.myfood.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double price;

	@ManyToOne
	@JoinColumn(name = "appetizer_id", referencedColumnName = "id", nullable = false)
	private Dish appetizer;

	@ManyToOne
	@JoinColumn(name = "first_id", referencedColumnName = "id", nullable = false)
	private Dish first;

	@ManyToOne
	@JoinColumn(name = "second_id", referencedColumnName = "id", nullable = false)
	private Dish second;

	@ManyToOne
	@JoinColumn(name = "dessert_id", referencedColumnName = "id", nullable = false)
	private Dish dessert;

	@Column(name = "visible", nullable = false)
	private boolean visible;

	@OneToMany(mappedBy = "menu")
    @JsonIgnore
    private List<ListOrder> listOrder;
	
	@OneToMany(mappedBy = "menu")
    private List<Dish> dish;


	public Menu() {
	}

	public Menu(Long id, Dish appetizer, Dish first, Dish second, Dish dessert, boolean visible , double price) {
		
		this.id = id;
		this.appetizer = appetizer;
		this.first = first;
		this.second = second;
		this.dessert = dessert;
		this.visible = visible;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dish getAppetizer() {
		return appetizer;
	}

	public void setAppetizer(Dish appetizer) {
		this.appetizer = appetizer;
	}

	public Dish getFirst() {
		return first;
	}

	public void setFirst(Dish first) {
		this.first = first;
	}

	public Dish getSecond() {
		return second;
	}

	public void setSecond(Dish second) {
		this.second = second;
	}

	public Dish getDessert() {
		return dessert;
	}

	public void setDessert(Dish dessert) {
		this.dessert = dessert;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
}

