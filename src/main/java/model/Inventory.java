package model;
import lombok.*;

import javax.swing.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Inventory {
    private int id_inventory;
    private String name;
    private double weight;
    private int age;
    private double cost;

    Inventory(String n, double w, int a, double c)
    {
        name = n;
        weight = w;
        age = a;
        cost = c;
    }

    public Inventory(List<JTextField> list)
    {
        name = String.valueOf(list.get(0).getText());
        weight = Double.parseDouble(String.valueOf(list.get(1).getText()));
        age = Integer.parseInt(String.valueOf(list.get(2).getText()));
        cost = Double.parseDouble(String.valueOf(list.get(3).getText()));
    }

}