package DSTeam3.maps.locations;

import DSTeam3.maps.base.*;

/* Location 3 */
public class TrattoriaTrussardi extends Location{
    public TrattoriaTrussardi(){
        super();
        this.nameOfLocation = "Trattoria Trussardi";
        this.menu = new TrattoriaTrussardiMenu();
        this.restaurant = new TrattoriaTrussardiRestaurant();
    }

    public void displayFoodMenu(){
        this.restaurant.displayMenu();
    }
}
