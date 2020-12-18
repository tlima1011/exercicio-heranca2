package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	
	//Atributos 
	private Date manufactureDate;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//Construtores 
	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(this.getName() + " (used) $" 
				+ String.format("%.2f", this.getPrice()) 
				+ " (Manufacture date: " + sdf.format(this.manufactureDate) +")"); 
		return sb.toString();
	}
}
