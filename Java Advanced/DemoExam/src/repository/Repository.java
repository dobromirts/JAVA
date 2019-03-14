package repository;


import java.util.TreeMap;

public class Repository {
    private static final int INIT_INDEX=0;
    TreeMap<Integer,Person> data;
    int index;

    public Repository() {
        this.data = new TreeMap<>();
        this.index=INIT_INDEX;
    }

    public void add(Person person){
        this.data.put(index,person);
        index++;
    }
    public Person get(int id){
        return this.data.get(id);
    }
    public boolean update(int id,Person newPerson){
        if (!this.data.containsKey(id)){
            return false;
        }
        this.data.put(id,newPerson);
        return true;
    }
    public boolean delete(int id){
        if (!this.data.containsKey(id)){
            return false;
        }
        this.data.remove(id);
        return true;
    }
    public int getCount(){
        return this.data.size();
    }
}
