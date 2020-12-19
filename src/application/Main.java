package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 
		
		ArrayList <Product> products = new ArrayList<>(); 
		Character type;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Double sum = 0.0, productPrice = 0.0, customsFee = 0.0, cf = 0.0; 
				
		System.out.print("Enter the number of products: "); 
		int n = sc.nextInt(); 
		
		for(int i = 0; i < n;i++) {
			System.out.printf("Product #%d data: \n",(i + 1));
			System.out.print("Common, used or imported (C/U/I)? ");
			type = sc.next().charAt(0); 
			type = Character.toUpperCase(type);
			sc.nextLine();
			System.out.print("Name: ");
			String productName = sc.nextLine(); //Tablet
			System.out.print("Price: $"); 
			productPrice = sc.nextDouble(); //260.00
			switch(type) {
				case 'I':
					System.out.print("Customs fee: "); 
					customsFee = sc.nextDouble(); //20.00
					cf += customsFee;
					sum += productPrice;
					products.add(new ImportedProduct(productName, productPrice, customsFee));
					break; 
				case 'U':  
					sum += productPrice;
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date manufacture = sdf.parse(sc.next());
					products.add(new UsedProduct(productName, productPrice, manufacture));
					break;
				default:
					sum += productPrice;
					products.add(new Product(productName, productPrice)); 
			}
		}
		sum += cf;
		Double avg = sum / products.size();
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		System.out.println("\nTotal Price $" +String.format("%.2f", sum));
		System.out.println("Average Price $" +String.format("%.2f", avg)); 
		sc.close();
	}
}
