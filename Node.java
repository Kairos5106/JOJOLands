public class Node<E>{
    protected E element;
    protected Node<E> next;

    public Node(){
        this.element = null;
        this.next = null;
    }

    public Node(E e){
        this.element = e;
        this.next = null;
    }
}