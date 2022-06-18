package model;
import lombok.*;

import javax.swing.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Persons {
    private int id_person;
    private String name;
    private String surname;
    private String patronymic;
    private String position;

    public Persons(List<JTextField> list)
    {
        name = String.valueOf(list.get(0).getText());
        surname = String.valueOf(list.get(1).getText());
        patronymic = String.valueOf(list.get(2).getText());
        position = String.valueOf(list.get(3).getText());
    }
}