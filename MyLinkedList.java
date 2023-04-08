public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /* Purpose: Adds the element e as zeroth element into the list
     * @param E e: element of type parameter E
     * Precondition:
     * 1) Linkedlist is empty
     * 2) Linkedlist contains at least 1 element/is occupied
     * Postcondition: LinkedList will contain at least more than 1 element
     */
    public void addFirst(E e){
        Node<E> firstNode = new Node<>(e);
        firstNode.next = head;
        head = firstNode;
        size++;
        if(size == 0){
            tail = head;
        }
    }

    /* Purpose: Adds the element e as the nth element into the list
     * @param E e: element of type parameter E
     * Precondition:
     * 1) Linkedlist is empty
     * 2) Linkedlist contains at least 1 element/is occupied
     * Postcondition: LinkedList will contain at least more than 1 element
     */
    public void addLast(E e){
        Node<E> lastNode = new Node<>(e);
        tail.next = lastNode;
        tail = lastNode;
        size++;
        if(size == 0){
            head = tail;
        }
    }

    /* Purpose: Adds the element e to the index = index into the list
     * @param index = the index to add element e into, e = the element to be stored inside the element
     * Precondition: 0 < index < size
     * Postcondition: Linkedlist will have at least 1 element
     */
    public void add(int index, E e){
        if((index < 0) || (index >= size)){ // print error message: index out of bounds
            System.out.println("Error: Index out of bounds");       
        }
        else if(index == 0){
            addFirst(e);
        }
        else if(index == size){
            addLast(e);
        }
        else{
            Node<E> pointer = head;
            Node<E> temp, temp1;
            temp = null;
            temp1 = null;
            for (int currentIndex = 1; currentIndex < size; currentIndex++) {
                pointer = pointer.next;
                if(currentIndex >= index - 1){
                    temp = pointer.next;
                    pointer.next = new Node<>(e);
                    size++;
                    pointer.next.next = temp;
                    break;
                }
            }
        }
    }

    /* Purpose: Removes the first item in the list
     * @return E: element of the first item that was removed
     * Precondition: 
     * - List must not be empty
     * - List has 1 item
     * Postcondition: - First element of list is removed
     */
    public E removeFirst(){
        if(size == 0){
            System.out.println("Error: List is empty");
            return null;
        }
        Node<E> temp = head;
        head = null;
        head = head.next;
        size--;
        if(size == 0){
            head = tail = null;
        }
        return temp.element;
    }

    /* Purpose: Removes the last item in the list
     * Precondition: List must not be empty
     * Postconditon: Last item in list will be removed
     * @return E: element of the last item that was removed
     */
    public E removeLast(){
        Node<E> temp = null;
        Node<E> pointer = head;
        if(size == 0){
            System.out.println("Error: List is empty");
            return null;
        }
        else if(size == 1){
            removeFirst();
        }
        else{
            for (int index = 1; index < size - 1; index++) {
                pointer = pointer.next;
                if(index == size - 2){
                    temp = tail;
                    tail = null;
                    pointer.next = null;
                    tail = pointer;
                    size--;
                }
            }
        }
        return temp.element;
    }

    /* Purpose: Removes the item at specified index
     * @param index: the index of item to be removed from the list
     * @return E: element of the item that was removed
     * Precondition: 
     */
    public E remove(int index){
        if(size <= 1 || index == 0){
            removeFirst();
        }
        else if(index == size - 1){
            removeLast();
        }
        else{
            Node<E> tempResult = null;
            Node<E> temp = null;
            Node<E> pointer = head;
            for (int pointerIndex = 1; pointerIndex < size - 1; pointerIndex++) {
                pointer = pointer.next;
                if(pointerIndex == index - 1){
                    temp = pointer.next.next;
                    tempResult = pointer.next;
                    pointer.next = null;
                    pointer.next = temp;
                    size--;
                    break;
                }
            }
            return tempResult.element;
        }
        return null;
    }

    /* Purpose: Finds if a list contains a certain element
     * @return true: if element is found, false: if element is absent in list
     * @param e: element to be searched
     */
    public boolean contains(E e){
        Node<E> pointer = null;
        for (int index = 0; index < size; index++) {
            if(index == 0){
                pointer = head;
            }
            else{
                pointer = pointer.next;
            }
            if(pointer.element.equals(e)){
                return true;
            }
        }
        return false;
    }

    /* Purpose: Returns the element of the item at specified index
     * @param index: index of the item element
     * @return element of the item at specified index
     */
    public E get(int index){
        Node<E> pointer = null;
        for (int pointerIndex = 0; pointerIndex < size; pointerIndex++) {
            if(pointerIndex == 0){
                pointer = head;
            }
            else{
                pointer = pointer.next;
            }
            if(pointerIndex == index){
                return pointer.element;
            }
        }
        System.out.println("Error: Element not found");
        return null;
    }

    public E getFirst(){
        if(size == 0){
            System.out.println("Error: List is empty");
            return null;
        }
        return head.element;
    }

    public E getLast(){
        if(size == 0){
            getFirst();
        }
        return tail.element;
    }

    public int indexOf(E e){
        Node<E> pointer = null;
        for (int index = 0; index < size; index++) {
            if(index==0){pointer = head;}else{pointer=pointer.next;}
            if(pointer.element.equals(e)){
                return index;
            }
        }
        return -1;
    }

    public int lastIndexOf(E e){
        // Initialize required variables
        int[] indexList = new int[size];
        Node<E> pointer = null;

        // Execute linear search for items in list and marking "1" in indexList at specified index if found item
        for (int i = 0; i < indexList.length; i++) {
            
        }

        // Return last index of item in indexList
        for (int i = indexList.length - 1; i >= 0; i--) {
            if(indexList[i] == 1){
                return i;
            }
        }
        
        // Default return
        return -1;
    }

    public E set(int index, E e){

    }

    public void clear(){

    }

    public void print(){

    }

    public void reverse(){

    }
}
