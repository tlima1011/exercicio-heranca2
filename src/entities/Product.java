package entities;

public class Product {
	
	//Atributos 
	private String name; 
	private Double price;
	
	//Construtor
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	} 
	
	//Métodos 
	public String priceTag() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(this.name + " $" +String.format("%.2f", this.price));
		return sb.toString();
	}
}
