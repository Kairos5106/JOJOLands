package DSTeam3.maps.locations;

import DSTeam3.maps.base.*;

/* Location 5 */
public class Libeccio extends Location{
    public Libeccio(){
        super();
        this.nameOfLocation = "Libeccio";
        this.menu = new LibeccioMenu();
        this.restaurant = new LibeccioRestaurant();
    }

    public void displayFoodMenu(){
        this.restaurant.displayMenu();
    }
}
