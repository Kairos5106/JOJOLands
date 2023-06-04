How to add your code to be implemented into the game:

1.  Add your code class file into the folder "source". 

    Make sure your source code has a unique name. Then, you will need to add it to the location menu class file of the location you 
    want your code to be implemented in.

2.  Navigate to DSTeam3 > maps > locations > (locationName)Menu.java

    Open the class file. Then, there are two methods you will need to define by yourself/add in more implementations:
        (1) defineOptions
        (2) execute

    The "defineOptions" method defines the options in the menu of the specific location the player is currently at.
    The "execute" method processes user input and takes the appropriate action depending on which option was selected.

3. Implement "defineOptions"

    A sample of the defineOptions code has been taken from the TownHallMenu file as per below:

    @Override
    public void defineOptions(){
        // Defining options and linking them to their respective suboptions
        Option moveTo = new Option("Move to nearby location");
        moveTo.addSuboptions("Cafe Deux Magots");
        moveTo.addSuboptions("Jade Garden");
        moveTo.addSuboptions("Morioh Grand Hotel");
        
        Option advanceNextDay = new Option("Advance to Next Day");
        
        Option saveGame = new Option("Save Game");

        Option exit = new Option("Exit");

        Option[] options = {moveTo, advanceNextDay, saveGame, exit};
        addOptions(options);
    }

    I will explain each code snippet in a logical order. First of all, the Option[] options array is what stores the name of each option
    in the menu that pops up when you FIRST enter that location. This is the array in which you will store your the name of your options
    in. 

    From there, you will need to know how to define an Option class. You can refer to the first line of the defineOptions method for this.

    Then, if after the option has been selected and it still has more options to show, for e.g. refer to first line of the "defineOptions" method,
    you will need to use the addSuboptions method to add more of those extra options. Refer to the "moveTo" Option object on the code.

    That's it! Now you need to implement the "execute" method.

4.  Implementing "execute"

    A sample of the defineOptions code has been taken from the TownHallMenu file as per below:

    @Override
    public void execute(String inputStr){
        switch(getSelectedTitle()){
            case "Move to nearby location":
                setGreeting("Select a location to move to: ");
                break;
            case "Cafe Deux Magots":

                // move to
            case "Jade Garden":

                break;
            case "Morioh Grand Hotel":
                
                break;
            case "Advance to Next Day":
                setAdvanceNextDay(true);
                break;
            case "Save Game":
                System.out.println("Not developed yet");
                break;
            case "Exit":
                setExitGame(true);
                setExitInterface(true);
                System.out.println("Exiting game...");
                break;
        }
    }

    The way that this method works is that it will detect which menu name that the user selected previously before taking an action.
    You will need to define/rework a "switch" statement manually. You will need to pass a string corresponding to an option into the method
    along with your code implementations into that method.

    For example, refer to the "defineOptions" sample above. In the "moveTo" Option object, you will need to add the specific action
    the method will take if the user selects a menu with the name say "Move to nearby location" or "Jade Garden. Refer to the above 
    sample for a more detailed view.


Thats it. Just try to make sure your code runs. If there is anything regarding the user inferface issue that you don't know how to fix,
just report to Kevin and he'll fix it.