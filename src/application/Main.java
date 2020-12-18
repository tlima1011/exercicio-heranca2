package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

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
			switch(type) {
				case 'I':
					sc.nextLine();
					System.out.print("Name: ");
					String productName = sc.nextLine(); //Tablet
					System.out.print("Price: $"); 
					productPrice = sc.nextDouble(); //260.00
					System.out.print("Customs fee: "); 
					customsFee = sc.nextDouble(); //20.00
					cf += customsFee;
					sum += productPrice;
					ImportedProduct imported = new ImportedProduct(productName, productPrice, customsFee); 
					products.add(imported);
					break; 
				case 'U': 
					sc.nextLine();
					System.out.print("Name: ");
					productName = sc.nextLine();
					System.out.print("Price: $");
					productPrice = sc.nextDouble(); 
					sum += productPrice;
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date manufacture = sdf.parse(sc.next());
					UsedProduct used = new UsedProduct(productName, productPrice, manufacture);  
					products.add(used);
					break;
				case 'C':
					sc.nextLine();
					System.out.print("Name: ");
					productName = sc.nextLine(); 
					System.out.print("Product: $");
					productPrice = sc.nextDouble();
					sum += productPrice;
					Product product = new Product(productName, productPrice);
					products.add(product); 
					break;
				default: 
					System.out.println("Inválido, tente outro");
			}
		}
		sum += cf;
		Double avg = sum / products.size();
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		System.out.println("Total Price $" +String.format("%.2f", sum));
		System.out.println("Average Price $" +String.format("%.2f", avg)); 
		sc.close();
	}
}
