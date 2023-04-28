package DSTeam3;

/* This class is used to initialize Jojolands */
public class Main{
    public static void main(String[] args) {
        /* Section 1: Code for initializing JOJOLands */
        /* Initializing required variables before opening menu */
        UserInterface ui = new UserInterface();
        boolean exitGame = false;
        int input = 0;

        /* Displaying menu and prompt user for input */
        ui.divider(70);
        ui.menu.openStartMenu();
        while(true){
            input = Integer.parseInt(ui.prompt("Select: "));
            if((input > 3) || (input < 1)){System.out.println("Please select a valid option.");}
            else{break;}
        }
        ui.divider(70);
        switch(input){
            case 1:
                ui.menu.openMapSelection();
                while(true){
                    input = Integer.parseInt(ui.prompt("Select: "));
                    if((input > 3) || (input < 1)){System.out.println("Please select a valid option.");}
                    else{break;}
                }
                break;
            case 2:
                System.out.println("Feature not available yet"); // insert load game feature 
                break;
            case 3:
                exitGame = true;
                System.out.println("Exiting JOJOLands...");
                break;
        }
        if(exitGame){return;}

        /* Section 2: Code for in-game processes */
        System.out.println("Not developed yet");
    }
}