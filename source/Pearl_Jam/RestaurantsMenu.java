package source.Pearl_Jam;

import ui.base.Menu;
import ui.base.Option;

public class RestaurantsMenu extends Menu {
    public RestaurantsMenu() {
        super("Welcome to the Restaurants!", "Restaurant");
        defineOptions();
        setDefaultOption();
    }

    public void defineOptions() {
        // Add the specific restaurant menu options
        Option viewMenuOption = new Option("View Menu");

        Option orderOption = new Option("Place Order");


        Option payOption = new Option("Pay Bill");


        Option exitOption = new Option("Exit");



        // Add the suboptions if needed
        // viewMenuOption.addSuboptions(...);

        // Add the options to the menu
        addOptions(new Option[]{viewMenuOption, orderOption, payOption, exitOption});
    }

    public void execute(String inputStr) {
        // Implement the logic for each menu option
        if (selectedTitleEquals("View Menu")) {
            // Logic for viewing the restaurant menu
        } else if (selectedTitleEquals("Place Order")) {
            // Logic for placing an order
        } else if (selectedTitleEquals("Pay Bill")) {
            // Logic for paying the bill
        } else if (selectedTitleEquals("Exit")) {
            setExitInterface(true);
        }
    }
}
