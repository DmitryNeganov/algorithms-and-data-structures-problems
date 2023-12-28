package org.dvn.ya.warmup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private static int k;
    private static List<Integer> stages;

    public static void main(String[] args) {
        int n;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {

            String firstInputLine = reader.readLine();
            k = Integer.parseInt(firstInputLine);

            String seconfInputLine = reader.readLine();
            n = Integer.parseInt(seconfInputLine);

            stages = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                String thirdLine = reader.readLine();
                stages.add(Integer.parseInt(thirdLine));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int resultTime= getRealTime();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

                writer.write(resultTime + "");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i: stages) {
            System.out.println(i);
        }
    }

    private static int getRealTime() {
        int time = 0;
         while (!stages.isEmpty()) {
            time += getKItemsFromStack(k, 0);
        }

        return time;
    }

    private static int getKItemsFromStack(int k, int elevatorPos) {
        int time = 0;
        int capacity = k;
        if (stages.isEmpty()) return elevatorPos + 1;
        int peopleAtStage = stages.get(stages.size() - 1);
        time += (stages.size() - 1) - elevatorPos;
        elevatorPos = (stages.size() - 1) - elevatorPos;
        if (capacity > peopleAtStage) {
            capacity = capacity - peopleAtStage;
            stages.remove(stages.size() - 1);
            time++;
            time += getKItemsFromStack(capacity, elevatorPos - 1);
        } else if (capacity == peopleAtStage) {
            stages.remove(stages.size() - 1);
            time += elevatorPos + 1;
        } else {
            stages.set(stages.size() - 1, peopleAtStage - capacity);
            time += elevatorPos + 1;
        }
     return time;
    }
}
