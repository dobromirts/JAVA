package customListWithSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T elemet) {
        this.data.add(elemet);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = this.data.get(firstIndex);
        this.data.set(firstIndex, data.get(secondIndex));
        this.data.set(secondIndex, temp);
    }

    public int greaterThan(T element) {
        int count = 0;
        for (T t : this.data) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T max() {
        return this.data.stream().max(Comparable::compareTo).get();
    }

    public T min() {
        return this.data.stream().min(T::compareTo).get();
    }

    public void forEach(Consumer<T> consumer) {
        for (T t : this.data) {
            consumer.accept(t);
        }
    }

    public int size(){
        return this.data.size();
    }
    public T get(int index){
        return this.data.get(index);
    }

}
