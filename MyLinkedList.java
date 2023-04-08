import java.util.ArrayList;

public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    protected int size;

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
        if(size == 0){
            addFirst(e);
        }
        else if(size==1){
            head.next = new Node<>(e);
            tail = head.next;
            size++;
        }
        else{ // has issues
            Node<E> pointer = null;
            for (int i = 0; i < size; i++) {
                if(i==0){pointer=head;}else{pointer=pointer.next;}
                if(i==size-1){
                    pointer.next = new Node<>(e);
                    tail = pointer.next;
                    size++;
                    break;
                }
            }
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
            Node<E> temp;
            temp = null;
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
        boolean[] indexList = new boolean[size];
        Node<E> pointer = null;
        // Execute linear search for items in list and marking "true" in indexList at specified index if found item
        for (int index = 0; index < indexList.length; index++) {
            if(index==0){pointer = head;}else{pointer=pointer.next;}
            if(pointer.element.equals(e)){
                indexList[index] = true;
            }
        }
        // Return last index of item in indexList
        for (int index = indexList.length - 1; index >= 0; index--) {
            if(indexList[index] == true){
                return index;
            }
        }  
        // Default return
        return -1;
    }

    public E set(int index, E e){
        // Initialize required variables
        Node<E> result = null;
        Node<E> temp = null;
        Node<E> pointer = null;
        if(index == 0){
            result = head;
            temp = head.next;
            head = new Node<>(e);
            head.next = temp;
            return result.element;
        }
        else{
            // Initiate linear search for item
            for (int i = 0; i < size; i++) {
                if(i==0){pointer=head;}else{pointer=pointer.next;}
                if(i==index-1){
                    result = pointer.next;
                    temp = pointer.next.next;
                    pointer.next = null; // deleting item at specified index
                    pointer.next = new Node<>(e); // setting new item at specified index
                    pointer.next.next = temp;
                    return result.element;
                }
            }
        }
        return null;
    }

    public void clear(){
        Node<E> pointer = null;
        Node<E> pointerNext = null;
        for (int index = 0; index < size - 1; index++) {
            if(index==0){
                pointer = head;
                pointerNext = pointer.next;
            }
            else{
                pointer = pointerNext;
                pointerNext = pointerNext.next;
            }
            pointer = null;
        }
        head = tail = null;
        size = 0;
    }

    public void print(){
        Node<E> pointer = null;
        for (int index = 0; index < size; index++) {
            if(index==0){pointer = head;}else{pointer=pointer.next;}
            System.out.print(pointer.element);
            if(index != size - 1){System.out.print(", ");}
        }
        System.out.println();
    }

    public void reverse(){
        Node<E> pointer = null;
        ArrayList<Node<E>> list = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            if(index==0){pointer = head;}else{pointer=pointer.next;}
            list.add(pointer);
        }
        for (int index = list.size() - 1; index >= 0; index--) {
            System.out.print(list.get(index).element);
            if(index != 0){System.out.print(", ");}
        }
        System.out.println();
    }

    public E getMiddleValue(){ // consider even and odd list sizes. consider small list sizes
        // Initalize required variables
        Node<E> pointer = null;
        Node<E> temp = null;
        int mid, mid1, mid2;
        mid1 = 0;
        mid2 = 0;
        boolean odd = false;
        // Calculate midpoint
        if(size % 2 == 1){ // size = odd
            mid = ((size + 1) / 2 - 1); // minus 1 because need to convert into index form
            odd = true;
        }
        else{
            mid = size / 2;
            // convert to index form
            mid1 = mid - 1;
            mid2 = mid;
        }
        for (int index = 0; index < size; index++) {
            if(index==0){pointer=head;}else{pointer=pointer.next;}
            if(odd){
                if(index==mid){
                    return pointer.element;
                }
            }
            if(!odd){
                if(index==mid1){
                    return pointer.element;
                }
            }
        }
        return null;
    }
}
