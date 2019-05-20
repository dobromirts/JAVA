package listener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> observers;

    public Dispatcher() {
        this.name="";
        this.observers =new ArrayList<>();
    }

    public void addObserver(NameChangeListener observer){
        this.observers.add(observer);
    }
    public void removeObserver(NameChangeListener obsever){
        this.observers.remove(obsever);
    }

    public void setName(String name){
        this.name=name;
        this.fireOnNameChaneEvent();

    }

    private void fireOnNameChaneEvent(){
        Even even=new Even(this,this.name);
        for (NameChangeListener observer : observers) {
            observer.handleOnNameChange(even);
        }
    }
}
