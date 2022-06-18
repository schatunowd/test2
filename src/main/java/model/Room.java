package model;
import lombok.*;

import javax.swing.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Room {
    private int id_room;
    private int floor;
    private double square;
    private double temperature;
    private double humidity;

    public Room(List<JTextField> list)
    {
        floor = Integer.parseInt(String.valueOf(list.get(0).getText()));
        square = Double.parseDouble(String.valueOf(list.get(1).getText()));
        temperature = Double.parseDouble(String.valueOf(list.get(2).getText()));
        humidity = Double.parseDouble(String.valueOf(list.get(3).getText()));
    }
}
