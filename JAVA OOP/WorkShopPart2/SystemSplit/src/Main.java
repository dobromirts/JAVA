import core.Engine;
import core.SystemComponent;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        SystemComponent systemComponent=new SystemComponent();
        Engine engine=new Engine(systemComponent);
        engine.run();

        System.out.println(systemComponent.toString());

    }
}
