package DSTeam3.datastructures;

import java.util.ArrayList;

public class Stack<E>{
    private ArrayList<E> stack = new ArrayList<>();

    public Stack(){}

    public int getSize(){
        return stack.size();
    }

    /* Adds an element o to the top of the stack
     * @param o: element to be added
     */
    public void push(E o){
        stack.add(o);
    }

    /* Removes and returns the element from the top of the stack
     * @return element that was removed
     * Conditions:
     *  1) List must not be empty
     */
    public E pop(){
        return stack.remove(stack.size()-1);
    }

    /* Returns the element at the top of the stack */
    public E peek(){
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public String toString(){
        return "Stack: " + stack.toString();
    }

    public boolean search(E o){
        return stack.contains(o);
    }

    public void printStackElements(){
        System.out.println(stack);
    }
}