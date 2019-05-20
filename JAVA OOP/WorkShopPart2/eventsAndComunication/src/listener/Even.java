package listener;

import java.util.EventObject;

public class Even extends EventObject {
    private String changeName;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public Even(Object source,String changeName) {
        super(source);
        this.changeName=changeName;
    }

    public String getChangeName() {
        return changeName;
    }
}
