/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.MoodyBlues;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author firza
 * */

public class SalesInformation {
    private List<Food> sales;

    public SalesInformation() {
        sales = new ArrayList<>();
    }

    public void addSale(Food food) {
        sales.add(food);
    }

    public List<Food> getSales() {
        return sales;
    }

    public double getTotalSales() {
        double totalSales = 0.0;
        for (Food food : sales) {
            totalSales += food.getTotalPrice();
        }
        return totalSales;
    }

    public double getAverageSales() {
        return getTotalSales() / sales.size();
    }

    public int getQuantityForFood(String foodName) {
        int quantity = 0;
        for (Food food : sales) {
            if (food.getName().equals(foodName)) {
                quantity += food.getQuantity();
            }
        }
        return quantity;
    }
}
