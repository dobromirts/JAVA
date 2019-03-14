package genericcountstring;


public class Box <T extends Comparable<T>>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue().getClass().getName()+": "+getValue();
    }

    public int compareTo(Box<T> o){
        return this.value.compareTo(o.value);
    }


}
