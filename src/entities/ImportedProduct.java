package entities;

public class ImportedProduct extends Product{

	//Atributos 
	private Double customsFee;
	
	//Contrutores 
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee; 
	}
	//Getters and Setters 

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public double totalPrice() {
		return getPrice() + this.getCustomsFee();  
	}

	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName() + " $" + String.format("%.2f", totalPrice()) + " (Customs fee: $ " + String.format("%.2f", this.customsFee)+")");
		return sb.toString();
	}
}
