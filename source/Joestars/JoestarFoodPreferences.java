package DSTeam3.source.Joestars;

import java.util.ArrayList;
import java.util.List;

public class JoestarFoodPreferences {
    private List<String> restaurantChoices;
    private List<String> foodChoices;

    public JoestarFoodPreferences() {
        // Initialize the restaurant choices and food choices
        restaurantChoices = new ArrayList<>();
        foodChoices = new ArrayList<>();
    }

    public List<String> getRestaurantChoices() {
        return this.restaurantChoices;
    }

    public List<String> getFoodChoices() {
        return this.foodChoices;
    }

    public void setRestaurantChoices(List<String> restaurantChoices) {
        this.restaurantChoices = restaurantChoices;
    }

    public void setFoodChoices(List<String> foodChoices) {
        this.foodChoices = foodChoices;
    }

    public void setJonathanFoodPreferences(List<String[]> menuItems) {
        // Calculate the frequency of each food item
        int[] frequency = new int[menuItems.size()];
        for (int i = 0; i < menuItems.size(); i++) {
            String[] menuItem = menuItems.get(i);
            String food = menuItem[1];
            frequency[i] = calculateFoodFrequency(food);
        }

        // Find the most and least frequent food items
        int maxFrequency = Integer.MIN_VALUE;
        int minFrequency = Integer.MAX_VALUE;
        for (int i = 0; i < frequency.length; i++) {
            maxFrequency = Math.max(maxFrequency, frequency[i]);
            minFrequency = Math.min(minFrequency, frequency[i]);
        }

        // Add the food choices that satisfy the preference condition
        for (int i = 0; i < frequency.length; i++) {
            String[] menuItem = menuItems.get(i);
            String food = menuItem[1];
            if (frequency[i] <= minFrequency + 1 && frequency[i] >= maxFrequency - 1) {
                foodChoices.add(food);
            }
        }
    }

    public void setJosephFoodPreferences(List<String[]> menuItems) {
        // Add all food items to the food choices list
        for (String[] menuItem : menuItems) {
            String food = menuItem[1];
            foodChoices.add(food);
        }
    }

    public void setJotaroFoodPreferences(List<String[]> menuItems) {
        // Add all food items from one restaurant at a time
        for (String[] menuItem : menuItems) {
            String restaurant = menuItem[0];
            restaurantChoices.add(restaurant);
        }
    }

    public void setJosukeFoodPreferences(List<String[]> menuItems) {
        double totalCost = 0;
        double weeklyBudget = 100;
        int borrowAmount = 0;

        // Calculate the total cost of food choices and determine if borrowing is needed
        for (String[] menuItem : menuItems) {
            String food = menuItem[1];
            double price = Double.parseDouble(menuItem[2]);
            totalCost += price;
            foodChoices.add(food);
        }

        // Check if the total cost exceeds the weekly budget
        if (totalCost > weeklyBudget) {
            borrowAmount = (int) Math.ceil(totalCost - weeklyBudget);
        }

        // Adjust the food choices based on the borrowing amount
        if (borrowAmount > 0) {
            for (int i = 0; i < borrowAmount; i++) {
                foodChoices.remove(foodChoices.size() - 1);
            }
        }
    }

    public void setGiornoFoodPreferences(List<String[]> menuItems) {
        String lastDish = "";
        boolean sameDishAsLast = false;

        // Find the Italian restaurant Trattoria Trussardi and add all its dishes
        for (String[] menuItem : menuItems) {
            String restaurant = menuItem[0];
            String food = menuItem[1];

            if (restaurant.equalsIgnoreCase("Trattoria Trussardi")) {
                restaurantChoices.add(restaurant);

                if (foodChoices.size() > 0 && food.equalsIgnoreCase(foodChoices.get(foodChoices.size() - 1))) {
                    sameDishAsLast = true;
                    lastDish = food;
                } else {
                    foodChoices.add(food);
                }
            }
        }

        // If there's only one option available, Giorno will order it
        if (foodChoices.size() == 1) {
            foodChoices.add(foodChoices.get(0));
        }

        // If the last dish is the same as the previous one, Giorno will order a different dish
        if (sameDishAsLast) {
            foodChoices.remove(lastDish);
        }
    }

    public void setJolyneFoodPreferences(List<String[]> menuItems, String lastRestaurant) {
        String currentRestaurant = "";

        // Find the restaurant that is different from the last one
        for (String[] menuItem : menuItems) {
            String restaurant = menuItem[0];
            String food = menuItem[1];

            if (!restaurant.equalsIgnoreCase(lastRestaurant)) {
                currentRestaurant = restaurant;
                break;
            }
        }

        // Add all the dishes from the current restaurant to the food choices
        for (String[] menuItem : menuItems) {
            String restaurant = menuItem[0];
            String food = menuItem[1];

            if (restaurant.equalsIgnoreCase(currentRestaurant)) {
                restaurantChoices.add(restaurant);
                foodChoices.add(food);
            }
        }
    }

    private int calculateFoodFrequency(String food) {
        int frequency = 0;
        for (String choice : foodChoices) {
            if (choice.equalsIgnoreCase(food)) {
                frequency++;
            }
        }
        return frequency;
    }
}

