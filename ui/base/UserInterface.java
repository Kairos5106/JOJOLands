package DSTeam3.ui.base;

import java.util.Scanner;

/* Purpose: Everything involving the game user interface such as printing output to the terminal to prompting user input */
public class UserInterface {
    /* Create instance variables */
    protected Menu currentMenu; // menu changes depending on the location

    /* Constructors */
    public UserInterface(){
        this.currentMenu = null;
    }

    public UserInterface(Menu currentMenu){
        this.currentMenu = currentMenu;
    }

    /* ****************** Method A: Getter and setter methods ****************** */

    public void setCurrentMenu(Menu menu){
        this.currentMenu = menu;
    }

    public Menu getCurrentMenu(){
        return this.currentMenu;
    }

    public boolean getExitGame(){
        return this.currentMenu.getExitGame();
    }

    public boolean getExitInterface(){
        return this.currentMenu.getExitInterface();
    }

    /* Method B: Display methods */

    /* Prints a divider in the terminal */
    public void divider(int length){ // according to sample, length = ~70
        for (int i = 0; i < length; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    /* Purpose: Displays the menu greeting, followed by options */
    public void runDisplay(){
        currentMenu.runDisplay();
    }

    /* Method C: Processing methods */
    public void initiate(){
        currentMenu.defineOptions();
        String input = "";
        divider(70);
        while(!getExitInterface()){
            currentMenu.runDisplay();
            input = prompt("Select: ", currentMenu.getMaxOptionRange());
            currentMenu.setSelected(Integer.parseInt(input)-1);
            divider(70);
            currentMenu.execute(input);
            currentMenu.setCurrentOption(Integer.parseInt(input)-1);
        }
    }

    /* Purpose: Prompts a question to the user and returns a string of the user input 
     * Has an overload method that is used for specifically choosing from a bunch of numerical options
    */
    public String prompt(String prompt){
        Scanner in = new Scanner(System.in);
        System.out.print(prompt);
        String userInput = in.next();
        return userInput;
    }

    /* Prompts the user to enter a proper range of selectable numerical options */
    public String prompt(String prompt, int maxOfRange){
        Scanner in = new Scanner(System.in);
        String userInput;
        while(true){
            System.out.print(prompt);
            userInput = in.next();
            if((Integer.parseInt(userInput) > maxOfRange) || (Integer.parseInt(userInput) < 1)){
                System.out.println("Please select a valid option");
            }
            else{break;}
        }
        return userInput;
    }
}