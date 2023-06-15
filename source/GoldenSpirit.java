
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DSTeam3.source;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.tree.TreeNode;


public class GoldenSpirit  {
    
    static TreeMap familyTree = new TreeMap<>();
    static String personOne, personTwo;
    static Scanner sc = new Scanner(System.in);
    static boolean exit = false;

    /*public GoldenSpirit (){
        System.out.println("Welcome to The Golden Spirit!");
        System.out.println("Here, you'll be able to find the lowest common ancestors of any two Joestars\n");
        GoldenSpirit ();
    }*/
    
    public static void GoldenSpirit (){
        createTreeMap();
        getJoestarName();
        getInput();
        if(exit)
            return;
        lowestCommonAncestors(personOne, personTwo);
        System.out.print("Do you want to try again? [y/n]: ");
        String input = sc.nextLine();
        if(input.equals("y")){
            System.out.println("");
            GoldenSpirit ();
            System.out.println("\n======================================================================");
        }
        else
            System.out.println("Returning back....");
    }
    
    public static void getJoestarName() {
        int i = 0;
        System.out.println("+-----+---------------------+");
        System.out.println("| No. | Character Name      |");
        System.out.println("+-----+---------------------+");
        for (Object name : familyTree.getAllTreeNodeObjects()) {
            String formattedName = String.format("%-20s", name);
            System.out.printf("| %-4d| %s|\n", i + 1, formattedName);
            i++;
        }
        System.out.println("+-----+---------------------+");
        System.out.println("");
    }

    
    public static void createTreeMap(){
        familyTree.addTreeEdge("Jolyne Cujoh", "Jotaro Kujo");
        familyTree.addTreeEdge("Jotaro Kujo", "Sadao Kujo");
        familyTree.addTreeEdge("Jotaro Kujo", "Holy Kujo");
        familyTree.addTreeEdge("Holy Kujo", "Suzi Q");
        familyTree.addTreeEdge("Holy Kujo", "Joseph Joestar");
        familyTree.addTreeEdge("Josuke Higashikata", "Tomoko Higashikata");
        familyTree.addTreeEdge("Josuke Higashikata", "Joseph Joestar");
        familyTree.addTreeEdge("Joseph Joestar", "Lisa Lisa");
        familyTree.addTreeEdge("Joseph Joestar", "George Joestar II");
        familyTree.addTreeEdge("George Joestar II", "Erina Joestar");
        familyTree.addTreeEdge("George Joestar II", "Jonathan Joestar");
        familyTree.addTreeEdge("Giorno Giovanna", "DIO");
        familyTree.addTreeEdge("Giorno Giovanna", "Jonathan Joestar");
        familyTree.addTreeEdge("Jonathan Joestar", "Mary Joestar");
        familyTree.addTreeEdge("Jonathan Joestar", "George Joestar I");
    }
    
    public static void lowestCommonAncestors(String personOne, String personTwo){
        ArrayList<String> ancestorsListOne = new ArrayList<>();
        ArrayList<String> ancestorsListTwo = new ArrayList<>();
        TreeNode<String> lowestCommonAncestors = null;
        String shorter = null;
        
        //searching for all ancestors for personOne
        ancestorsListOne = findAncestors(personOne);
        
        //searching for all ancestors for personTwo
        ancestorsListTwo = findAncestors(personTwo);
        
        //compare to get the list with fewer ancestors
        ArrayList<String> shorterList, longerList;
        if(ancestorsListOne.size()<ancestorsListTwo.size()){
            shorterList = ancestorsListOne;
            longerList = ancestorsListTwo;
            shorter = personOne;
        }else{
            shorterList = ancestorsListTwo;
            longerList = ancestorsListOne;
            shorter = personTwo;
        }
                
        //compare and get the lowest common ancestors
        boolean found = false;
        for(int i=0; i<shorterList.size(); i++){
            for(int j=0; j<longerList.size(); j++){
                if(shorterList.get(i).equals(longerList.get(j))) {
                    if (!longerList.get(j).equals(personOne) && !longerList.get(j).equals(personTwo)) {
                        if(i>0)
                            lowestCommonAncestors = familyTree.getTreeNode(shorterList.get(i-1));
                        else
                            lowestCommonAncestors = familyTree.getTreeNode(shorter);
                        found = true;
                        break;
                    }
                }                
            }
            if(found)
                break;
        }
        
        //print the lowest common ancestors
        System.out.printf("Lowest Common Ancestors of %s and %s:\n", personOne, personTwo);
        if(found){
            TreeEdge<String> ancestor = lowestCommonAncestors.firstTreeEdge;
            System.out.print(ancestor.parentNode.treeNodeInfo);
            ancestor = ancestor.nextEdge;
            while(ancestor!=null && longerList.contains(ancestor.parentNode.treeNodeInfo)){
                System.out.print(", " + ancestor.parentNode.treeNodeInfo);
                ancestor = ancestor.nextEdge;
            }
        }else{
            System.out.println("None");
        }
        System.out.println("\n======================================================================");
    }
    
    public static ArrayList<String> findAncestors(String person){
        ArrayList<String> list = new ArrayList<>();
        TreeNode<String> childNode = familyTree.getTreeNode(person);
        TreeEdge<String> edge = childNode.firstTreeEdge;
        while(edge!=null){
            list.add(edge.parentNode.treeNodeInfo);
            if(edge.nextEdge!=null){
                TreeEdge<String> nextEdge = edge.nextEdge;
                list.add(nextEdge.parentNode.treeNodeInfo);
            }
            childNode = edge.parentNode;
            edge = childNode.firstTreeEdge;
        }
        return list;
    }
    
    public static void getInput(){
        System.out.print("Enter the name of the first Joestar: ");
        personOne = sc.nextLine();
        System.out.print("Enter the name of the second Joestar: ");
        personTwo = sc.nextLine();
        System.out.println("======================================================================");
        if(!familyTree.hasTreeNode(personOne))
            System.out.println("Invalid input for first Joestar");
        if(!familyTree.hasTreeNode(personTwo))
            System.out.println("Invalid input for second Joestar");
        
        if(!familyTree.hasTreeNode(personOne) || !familyTree.hasTreeNode(personTwo)){
            System.out.print("Do you want to try again? [y/n]: ");
            String input = sc.nextLine();
            if(input.equals("y")){
                System.out.println("");
                getJoestarName();
                getInput();
            }
            else{
                System.out.println("Returning back....");
                exit = true;
            }
        }
    }

    private static class TreeEdge<T extends Comparable<T>>  {

        private TreeNode<T> parentNode;
        private TreeEdge<T> nextEdge;        
                
    public TreeEdge(TreeNode<T> parentNode, TreeEdge<T> nextEdge){     
    
        this.parentNode = parentNode;
        this.nextEdge = nextEdge;
    }
           }
 

    private static class TreeNode<T extends Comparable<T>> {
        T treeNodeInfo;
        TreeNode<T> nextTreeNode;
        TreeEdge<T> firstTreeEdge;

    public TreeNode(T item, TreeNode<T> nextTreeNode) {
        treeNodeInfo = item;
        this.nextTreeNode = nextTreeNode;
        firstTreeEdge = null;
        }
    }
    
    private static class TreeMap<T extends Comparable<T>>{
        TreeNode<T> head;
    
    //check if the tree node (person) 
    public boolean hasTreeNode(T v){
        if (head==null)
            return false;
        TreeNode<T> temp = head;
        while (temp!=null){
            if ( temp.treeNodeInfo.compareTo( v ) == 0 )
                return true;
            temp=temp.nextTreeNode;
        }
        return false;
    }
    
    //add the tree node
    public void addTreeNode(T v){
        if (hasTreeNode(v)==false){
            TreeNode<T> temp=head;
            TreeNode<T> newTreeNode = new TreeNode<>(v, null);
            if (head==null)   
                head=newTreeNode;
            else{
                TreeNode<T> previous=head;
                while (temp!=null){
                    previous=temp;
                    temp=temp.nextTreeNode;
                }
                previous.nextTreeNode=newTreeNode;
            }
        }
    }
    
    //add edge between the nodes 
    public void addTreeEdge(T current, T parent){
        addTreeNode(current);
        addTreeNode(parent);
        TreeNode<T> currentTreeNode = head;
        while (currentTreeNode!=null){
            if ( currentTreeNode.treeNodeInfo.compareTo( current ) == 0 ){
                // Reached source node, look for destination now
                TreeNode<T> parentTreeNode = head;
                while (parentTreeNode!=null){
                    if ( parentTreeNode.treeNodeInfo.compareTo( parent ) == 0 ){
                        // Reached destination vertex, add edge here
                        TreeEdge<T> newTreeEdge = new TreeEdge<>(parentTreeNode, currentTreeNode.firstTreeEdge);
                        currentTreeNode.firstTreeEdge=newTreeEdge;
                    }
                    parentTreeNode=parentTreeNode.nextTreeNode;
                }
            }
            currentTreeNode=currentTreeNode.nextTreeNode;
        }
    }
    
    //get all the people's name
    public ArrayList<T> getAllTreeNodeObjects(){
        ArrayList<T> list = new ArrayList<>();
        TreeNode<T> temp = head;
        while (temp!=null){
            list.add(temp.treeNodeInfo);
            temp=temp.nextTreeNode;
        }
        return list;
    }
    
    //get the required node
    public TreeNode<T> getTreeNode(T v){
        TreeNode<T> temp = head;
        while (temp != null) {
            if (temp.treeNodeInfo.compareTo(v) == 0) {
                return temp;
            }
            temp = temp.nextTreeNode;
        }
        return null;
    }
    }
    
    
}

    
    
   