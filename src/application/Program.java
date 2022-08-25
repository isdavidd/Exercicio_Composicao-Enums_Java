package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter client data: ");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		
		int day = sc.nextInt();
		int month = sc.nextInt();
		int year = sc.nextInt();
	
		LocalDate ld1 = LocalDate.of(year, month, day);
		
		Client client = new Client (name, email, ld1);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(LocalDateTime.now(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		System.out.println();
		sc.nextLine();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #"+ i + " item data:");
		
			System.out.println("Product name: ");
			String productName = sc.nextLine();
			
			System.out.println("Product Price: ");
			double productPrice = sc.nextDouble();
			
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println();
			Product product = new Product(productName, productPrice);
			
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			order.addItem(it);
		}
		
		System.out.println(order);
		
		sc.close();
		
	}
}
