package DSTeam3.maps.locations;

import DSTeam3.maps.base.*;
import DSTeam3.source.MoodyBlues.MoodyBlues;

/* Location 7 */
public class JadeGarden extends Location{
    public JadeGarden(){
        super();
        this.nameOfLocation = "Jade Garden";
        this.menu = new JadeGardenMenu();
        this.restaurant = new JadeGardenRestaurant();
    }

    public void displayFoodMenu(){
        this.restaurant.displayMenu();
    }
}
