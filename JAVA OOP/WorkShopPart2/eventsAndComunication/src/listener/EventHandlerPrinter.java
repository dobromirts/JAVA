package listener;

public class EventHandlerPrinter implements NameChangeListener {
    @Override
    public void handleOnNameChange(Even even) {
        System.out.println(String.format("Dispatcher's name changed to %s.",even.getChangeName()));

    }
}
