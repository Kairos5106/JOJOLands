package DSTeam3;

import java.util.Scanner;
import java.util.ArrayList;

/* Purpose: Everything involving the game user interface such as printing output to the terminal to prompting user input */
public class UserInterface {
    /* Create instance variables */
    Clock gameClock = new Clock();

    /* Constructors */
    public UserInterface(){}

    /* Class methods */
    /* Purpose: Prompts a question to the user and returns a string of the user input */
    public String prompt(String prompt){
        Scanner in = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = in.nextLine();
        in.close();
        return userInput;
    }

    /* Prints a divider in the terminal */
    public void divider(int length){ // according to sample, length = ~40
        for (int i = 0; i < length; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    /* Purpose: Used to initialize the game. Brings the terminal to the start menu */
    public void start(){

    }
}

class Menu{
    ArrayList<Option> options = new ArrayList<>();
    private String greeting; // represent text that appears before the options show up
    private String location;

    public Menu(String greeting, String location){
        this.greeting = greeting;
        this.location = location;
    }

    public void printGreeting(){
        System.out.println(this.greeting);
    }

    public void printLocation(){
        System.out.println();
    }

    public void printOptions(){
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("[%s] %s\n", i+1, options.get(i));
            if(options.get(i).hasSuboptions()){
               int charValue = (int) 'A';
               for (int j = 0; j < options.get(i).getSuboptionsCount(); j++) {
                   System.out.printf("[%c] %s     ", (char)charValue++, options.get(i).suboptions.get(j));
               }
               System.out.println();
            }
        }
    }

    public void displayMenu(){
        printGreeting();
        if(location != null){
            printLocation();
        }
        printOptions();
    }

    public static void main(String[] args) {
        // Defining start menu
        
    }
}

class Option{
    private String title;
    ArrayList<Option> suboptions = new ArrayList<>();

    public Option(String title){
        this.title = title;
    }

    public void addSuboptions(String suboptionsTitle){
        suboptions.add(new Option(suboptionsTitle));
    }
    
    public String toString(){
        return this.title;
    }

    public int getSuboptionsCount(){
        return this.suboptions.size();
    }

    public boolean hasSuboptions(){
        if(suboptions.size() != 0){
            return true;
        }
        else{
            return false;
        }
    }
}

/* Purpose: Keeps track of game time */
class Clock{
    private int dayCount;
    private int dayOfWeek; // every week's first day is Sunday
    public Clock(){
        this.dayCount = this.dayOfWeek = 1;
    }

    /* Returns a string describing the current day */
    public String dayInfo(){
        return "It's Day " + this.dayCount + " (" + computeDay(this.dayOfWeek) + ") of our journey in JOJOLands!";
    }

    /* Returns a string of the current day according to the numeric input, dayCount */
    public String computeDay(int dayOfWeek){
        String day = "";
        switch(dayOfWeek){
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }

    /* Purpose: Updates all of the relevant variables when a day ends */
    public void endDay(){
        dayCount++;
        if(dayOfWeek == 7){
            dayOfWeek = 1;
        }
        else{
            dayOfWeek++;
        }
    }
}