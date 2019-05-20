package trafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        String[]lights=reader.readLine().split("\\s+");
        int updates=Integer.parseInt(reader.readLine());

        List<TrafficLight>trafficLights=new ArrayList<>();


        for (String light : lights) {
            TrafficLight trafficLight=new TrafficLight(Lights.valueOf(light));
            trafficLights.add(trafficLight);
        }

        StringBuilder sb=new StringBuilder();

        for (int i = 0; i <updates ; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                sb.append(trafficLight.getLight()).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());




    }
}
