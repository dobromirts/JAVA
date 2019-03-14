package linkedlist;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public void addFirst(int element){
        Node node=new Node(element);

        if (this.isEmpty()){
            this.tail=node;
        }else {
            this.head.prev=node;
            node.next=this.head;
        }
        this.head=node;

        this.size++;
    }

    public void addLast(int element){
        Node node=new Node(element);
        if (this.isEmpty()){
            this.head=node;
        }else {
            this.tail.next=node;
            node.prev=this.tail;
        }
        this.tail=node;

        this.size++;
    }
    public int removeFirst(){
        if (this.isEmpty()){
            throw new InvalidDnDOperationException("Removed called from collection with size 0");
        }

        Node deleted=this.head;
        if (this.size==1){
            this.head=null;
            this.tail=null;
        }else {
            this.head=this.head.next;
            this.head.prev=null;
            deleted.next=null;
        }

        this.size--;
        return deleted.value;
    }
    public int removeLast(){
        if (this.isEmpty()){
            throw new InvalidDnDOperationException("Removed called from collection with size 0");
        }

        Node deleted=this.tail;
        this.tail=this.tail.prev;
        deleted.prev=null;

        if (this.size==1){
            this.head=null;
        }else {
            this.tail.next=null;
        }
        this.size--;
        return deleted.value;
    }

    public void forEach(Consumer<Integer>consumer){
        Node current=this.head;

        while (current!=null){
            consumer.accept(current.value);

            current=current.next;
        }
    }

    public int[] toArray(){
        int[]result=new int[this.size];
        int index=0;

        Node current=this.head;
        while (current!=null){
            result[index]=current.value;
            current=current.next;
            index++;
        }
        return result;
    }
    public void addAfter(int searchElement,int newElement){
        if (this.isEmpty()){
            throw new InvalidDnDOperationException("addAfter on empty list");
        }

        Node current=this.head;

        while (current!=null){
            if (current.value==searchElement){
                Node node=new Node(newElement);
                node.next=current.next;
                node.prev=current;

                if (current.next!=null){
                    node.next.prev=node;
                }else {
                    this.tail=node;
                }
                current.next=node;

                this.size++;
                return;
            }

            current=current.next;
        }
        throw new InvalidDnDOperationException("Search element not found");

    }

    public int removeAfter(int searchElement){
        if (this.isEmpty()){
            throw new InvalidDnDOperationException("removeAfter on empty list");
        }
        Node current=this.head;

        while (current!=null){
            if (current.value==searchElement){

                Node forDeletion=current.next;
                if (forDeletion==null){
                    throw new InvalidDnDOperationException("no element after search element");
                }
                current.next=forDeletion.next;

                if (current.next==null){
                    this.tail=current;
                }else {
                    current.next.prev=current;
                }


                forDeletion.next=null;
                forDeletion.prev=null;

                return forDeletion.value;

            }

            current=current.next;
        }
        throw new InvalidDnDOperationException("Search element not found");
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }
}
