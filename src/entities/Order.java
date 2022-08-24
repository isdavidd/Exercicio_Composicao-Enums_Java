package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	private LocalDateTime moment;
	private OrderStatus status;
	
	private Client client;
	
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Order() {
		
	}
	
	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
		
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
		System.out.println("Added item: "+ item.getProduct().getName() + "\n");
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
		System.out.println("Removed item: " + item.getProduct().getName()+ "\n");
	}
	
	public Double total() {
		Double sum = 0.0;
		for(OrderItem oi: items) {
			sum += oi.subTotal();
		}
		System.out.println("Total Price: "+ sum);
		return sum;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(fmt.format(moment)+ "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items: \n");
		for (OrderItem item: items) {
			sb.append(item + "\n");
		}
		sb.append(total());
		return sb.toString();
	}
}
