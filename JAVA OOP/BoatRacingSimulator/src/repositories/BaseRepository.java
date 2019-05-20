package repositories;


import interfaces.BoatEngine;
import interfaces.Model;

import java.util.HashMap;
import java.util.Map;

public class BaseRepository<T extends Model> {
    private Map<String,T> dataStore;

    public BaseRepository () {
        this.dataStore = new HashMap<>();
    }

    public boolean save(T entry){
        if (dataStore.containsKey(entry.getModel())) {
            return false;
        }
        this.dataStore.put(entry.getModel(), entry);
        return true;
    }

    public T getByModel(String model) {
        return this.dataStore.get(model);
    }
}
