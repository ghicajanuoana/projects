package bll.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable{
private int orderID;
private int clientID;
private  String orderDate;
private double price;

public Order(int orderID, int clientID, String orderDate, double price)
{
    this.orderID = orderID;
    this.clientID= clientID;
    this.orderDate = orderDate;
    this.price=price;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return (orderID == order.orderID) && (clientID == order.clientID) && Objects.equals(orderDate, order.orderDate);
}

public int hashCode() {
    return Objects.hash(orderID, clientID, orderDate);
}
@Override
public String toString() {
    return "Order{" +" orderID= " + orderID + ", clientID= " + clientID + ", orderDate= " + 
    orderDate + ", price= " + price +'}';
}
public int getOrderID() {
    return orderID;
}

public void setOrderID(int orderID) {
    this.orderID = orderID;
}

public int getClientID() {
    return clientID;
}

public void setClientID(int clientID) {
    this.clientID = clientID;
}

public  String getOrderDate() {
    return orderDate;
}

public void setOrderDate( String orderDate) {
    this.orderDate = orderDate;
}
public double getPrice() {
    return price;
}
public void setPrice(double price) {
    this.price = price;
}

}
