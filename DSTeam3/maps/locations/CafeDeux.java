package DSTeam3.maps.locations;

import DSTeam3.maps.base.*;

/* Location 8 */
public class CafeDeux extends Location{
    public CafeDeux(){
        super();
        this.nameOfLocation = "Cafe Deux Magots";
        this.menu = new CafeDeuxMenu();
        this.restaurant = new CafeDeuxRestaurant();
    }

    public void displayFoodMenu(){
        this.restaurant.displayMenu();
    }
}