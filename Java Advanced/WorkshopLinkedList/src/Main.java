import linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList linkedList=new LinkedList();

        System.out.println(linkedList.isEmpty());

        linkedList.addFirst(5);

        System.out.println(linkedList.getHead().getValue());
        System.out.println(linkedList.getSize());

        linkedList.addFirst(8);

        System.out.println(linkedList.getTail().getValue());
        linkedList.addLast(3);

        System.out.println(linkedList.removeFirst());

        System.out.println(linkedList.removeLast());


    }
}
