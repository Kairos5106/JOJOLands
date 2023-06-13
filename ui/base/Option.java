package DSTeam3.ui.base;

import java.util.ArrayList;

/* Purpose: Represent each option in a menu interface */
public class Option{
    protected String title;
    private ArrayList<Option> suboptions = new ArrayList<>();
    private ArrayList<Boolean> suboptionsSelected = new ArrayList<>();

    /* Constructors */
    public Option(){
        this.title = null;
    }
    
    public Option(String title){
        this.title = title;
    }

    /* Methods A: Getter and setter methods */

    public String getTitle(){
        return this.title;
    }

    /* Purpose: Returns the title of suboption at index = 'index' */
    public String getSuboptionTitle(int index){
        return this.suboptions.get(index).getTitle();
    }

    public void setSelected(int suboptionIndex){
        suboptionsSelected.set(suboptionIndex, true);
    }

    /*  */
    public int getSelected(){
        for (int i = 0; i < suboptionsSelected.size(); i++) {
            if(suboptionsSelected.get(i) == true){
                return i;
            }
        }
        return -1;
    }

    public void addSuboptions(Option suboption){
        suboptions.add(suboption);
        suboptionsSelected.add(false);
    }

    public void addSuboptions(String suboptionsTitle){
        suboptions.add(new Option(suboptionsTitle));
        suboptionsSelected.add(false);
    }

    // Method overload for above method
    public void addSuboptions(String[] suboptionsTitle){
        for (int i = 0; i < suboptionsTitle.length; i++) {
            addSuboptions(suboptionsTitle[i]);
        }
    }

    public int getSuboptionsCount(){
        return this.suboptions.size();
    }

    public ArrayList<Option> getSuboptionsList(){
        return this.suboptions;
    }

    public Option get(int index){
        return this.suboptions.get(index);
    }

    /* Methods B: Display methods */

    /* Methods C: Processing methods - Everything aside from A and B */

    public boolean hasSuboptions(){
        if(suboptions.size() > 0){return true;}
        else{return false;}
    }
}