package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public abstract class CommandImpl implements Executable {
    private String[]data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected CommandImpl(String[] data) {
        this.data = data;

    }

    protected String[] getData() {
        return data;
    }


}
