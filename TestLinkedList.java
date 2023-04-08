public class TestLinkedList {
    public static void main(String[] args) {
        // Q5a
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.addLast('a');
        list.addLast('b');
        list.addLast('c');
        list.addLast('d');
        list.addLast('e');

        // Q5b
        System.out.println("Printing list in regular order:");
        list.print();

        // Q5c
        System.out.println("Printing list in reverse order:");
        list.reverse();

        // Q5d
        System.out.println("Size of list is " + list.size);

        // Q5e
        System.out.println("Element of first item: " + list.getFirst());
        System.out.println("Element of last item: " + list.getLast());

        // Q5f
        System.out.println("Deleting third item... printing list:");
        list.remove(2);
        list.print();

        // Q5g
        list.add(2, 'c'); // set items back to normal
        list.print();
        System.out.println("Index of second item: " + list.indexOf('b'));
        System.out.println("Index of third item: " + list.indexOf('c'));

        // Q5h
        System.out.println("Checking if list has value 'c': " + list.contains('c'));

        // Q5i
        System.out.println("Replacing items individually with j,a,v,a... printing list:");
        list.set(0, 'j');
        list.set(1, 'a');
        list.set(2, 'v');
        list.set(3, 'a');
        list.removeLast();
        list.print();

        // Question 2
        // For lists with an even size
        MyLinkedList<Character> listEven = new MyLinkedList<>();
        listEven.addLast('a');
        listEven.addLast('b');
        listEven.addLast('c');
        listEven.addLast('d');
        System.out.println("Printing even list..");
        listEven.print();
        System.out.println("Middle value of even list: " + listEven.getMiddleValue());
        // For lists with an odd size
        MyLinkedList<Character> listOdd = new MyLinkedList<>();
        listOdd.addLast('a');
        listOdd.addLast('b');
        listOdd.addLast('c');
        listOdd.addLast('d');
        listOdd.addLast('e');
        System.out.println("Printing odd list...");
        listOdd.print();
        System.out.println(listOdd.getMiddleValue());
    }
}
