package stackIterator;


import java.util.Iterator;

public class Stack<T>implements Iterable<T> {
    private Node<T> top;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> currnet=top;

            @Override
            public boolean hasNext() {
                return this.currnet!=null;
            }

            @Override
            public T next() {
                T element= this.currnet.element;
                this.currnet=this.currnet.prev;
                return element;
            }
        };
    }


    private class Node<T> {
        private Node<T> prev;
        private T element;

        public Node(T element) {
            this.prev = null;
            this.element = element;
        }
    }

    public void push(T element){
        Node<T> newNode=new Node<>(element);
        if (this.top==null){
            this.top=newNode;
        }else {
            newNode.prev=this.top;
            this.top=newNode;
        }
    }
    public T pop(){
        if (this.top==null){
            throw new IndexOutOfBoundsException("No elements");
        }
        T element=this.top.element;
        this.top=this.top.prev;
        return element;
    }
}