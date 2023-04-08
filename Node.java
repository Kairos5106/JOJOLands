public class Node<E>{
    // Initialize instance variables
    protected E element;
    protected Node<E> next;

    // Constructors
    public Node(){
        this.element = null;
        this.next = null;
    }
    public Node(E e){
        this.element = e;
        this.next = null;
    }
}