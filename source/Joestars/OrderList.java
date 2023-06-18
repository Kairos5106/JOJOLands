package DSTeam3.source.Joestars;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private String name;
    private String food;
    private double price;
    private String restaurant;

    public OrderList(String name, String food, double price) {
        this.name = name;
        this.food = food;
        this.price = price;
    }

    public OrderList(String name, String food, double price, String restaurant) {
        this.name = name;
        this.food = food;
        this.price = price;
        this.restaurant = restaurant;
    }

    public void setRestaurant(String order) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public String getFood() {
        return food;
    }

    public double getPrice() {
        return price;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public static List<OrderList> getOrdersByMenuItem(List<String[]> orderList, String menuItem) {
        List<OrderList> orders = new ArrayList<>();
        for (String[] order : orderList) {
            String food = order[1];
            if (food.equals(menuItem)) {
                String name = order[0];
                double price = Double.parseDouble(order[2]);
                OrderList newOrder = new OrderList(name, food, price);
                orders.add(newOrder);
            }
        }
        return orders;
    }

}