package genericswapmetodstringss;

public class Box <T>{
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
        return String.format(getValue().getClass().getName()+": "+getValue());
    }
}
