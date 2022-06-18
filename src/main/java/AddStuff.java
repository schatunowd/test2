import dao.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import model.Inventory;
import model.Persons;
import model.Room;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

class InsertForm
{

}
class Example {
    JMenu add, delete, toXML;
    JMenuItem item, room, person, itemDel, roomDel, personDel, inventory, persons, room1;

    private void Insert(List<JTextField> names, int a)
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Inventory item; Persons person; Room room;
        try {
            if (a == 1) {
                item = new Inventory(names);
                DAO<Inventory, Integer> dao = new InventoryDAO(factory);
                dao.create(item);
            }
            if (a == 2) {
                person = new Persons(names);
                DAO<Persons, Integer> dao = new PersonsDAO(factory);
                dao.create(person);
            }
            if (a == 3) {
                room = new Room(names);
                DAO<Room, Integer> dao = new RoomDAO(factory);
                dao.create(room);
            }
            showMessageDialog(null, "Запись добавлена");
        }
        catch (Exception ex)
        {
            showMessageDialog(null, "Не удалось добавить запись, проверьте значения" + ex);
        }
    }
    Example() {
        JFrame mainFrame = new JFrame("");
        add = new JMenu("Добавить");
        delete = new JMenu("Удалить");
        toXML = new JMenu("XML");
        JMenuBar menuBar = new JMenuBar();
        item = new JMenuItem("предмет");
        room = new JMenuItem("помещение");
        person = new JMenuItem("ответственного");
        itemDel = new JMenuItem("предмет");
        roomDel = new JMenuItem("помещение");
        personDel = new JMenuItem("ответственного");
        inventory = new JMenuItem("предмет");
        persons = new JMenuItem("помещение");
        room1 = new JMenuItem("сотрудники");
        add.add(item);
        add.add(room);
        add.add(person);
        delete.add(itemDel);
        delete.add(roomDel);
        delete.add(personDel);
        toXML.add(inventory);
        toXML.add(persons);
        toXML.add(room1);
        menuBar.add(add);
        menuBar.add(delete);
        menuBar.add(toXML);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        inventory.addActionListener(e ->
        {
            try {
                new TableToXML("stuff").getTableData();
                showMessageDialog(null, "Файл создан");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        item.addActionListener(e -> {
            JFrame frameStuff = new JFrame("Добавление предмета");
            JTextField t = new JTextField(), t1 = new JTextField(), t2 = new JTextField(), t3 = new JTextField();
            JLabel l = new JLabel("Название");
            JLabel l1 = new JLabel("Вес");
            JLabel l2 = new JLabel("Возраст");
            JLabel l3 = new JLabel("Стоимость");

            l.setBounds(5,0,100,30);
            t.setBounds(5,30, 200,30);

            l1.setBounds(5,60,150,30);
            t1.setBounds(5,90, 200,30);

            l2.setBounds(5,120,150,30);
            t2.setBounds(5,150, 200,30);

            l3.setBounds(5,180,150,30);
            t3.setBounds(5,210, 200,30);

            JButton button1 = new JButton("Добавить");
            button1.setBounds(5, 270, 100, 30);

            frameStuff.add(t); frameStuff.add(t1); frameStuff.add(l); frameStuff.add(l1);
            frameStuff.add(t2); frameStuff.add(l2); frameStuff.add(t3); frameStuff.add(l3); frameStuff.add(button1);
            frameStuff.setSize(400,400);
            frameStuff.setLayout(null);
            frameStuff.setVisible(true);
            frameStuff.setLocationRelativeTo(null);

            button1.addActionListener(ae -> {
                List<JTextField> names = new ArrayList<>();
                names.add(t);
                names.add(t1);
                names.add(t2);
                names.add(t3);
                Insert(names, 1);
            });
        });
        room.addActionListener(e -> {
            JFrame frameStuff = new JFrame("Добавление помещения");
            JTextField t = new JTextField(), t1 = new JTextField(), t2 = new JTextField(), t3 = new JTextField();
            JLabel l = new JLabel("Этаж");
            JLabel l1 = new JLabel("Площадь");
            JLabel l2 = new JLabel("Температура");
            JLabel l3 = new JLabel("Влажность");

            l.setBounds(5,0,100,30);
            t.setBounds(5,30, 200,30);

            l1.setBounds(5,60,150,30);
            t1.setBounds(5,90, 200,30);

            l2.setBounds(5,120,150,30);
            t2.setBounds(5,150, 200,30);

            l3.setBounds(5,180,150,30);
            t3.setBounds(5,210, 200,30);

            JButton button1 = new JButton("Добавить");
            button1.setBounds(5, 270, 100, 30);

            frameStuff.add(t); frameStuff.add(t1); frameStuff.add(l); frameStuff.add(l1);
            frameStuff.add(t2); frameStuff.add(l2); frameStuff.add(t3); frameStuff.add(l3); frameStuff.add(button1);
            frameStuff.setSize(400,400);
            frameStuff.setLayout(null);
            frameStuff.setVisible(true);
            frameStuff.setLocationRelativeTo(null);

           button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    List<JTextField> names = new ArrayList<>();
                    names.add(t);
                    names.add(t1);
                    names.add(t2);
                    names.add(t3);
                    Insert(names, 3);
                }
            });
        });

        person.addActionListener(e -> {
            JFrame frameStuff = new JFrame("Добавление ответственного");
            JTextField t = new JTextField(), t1 = new JTextField(), t2 = new JTextField(), t3 = new JTextField();
            JLabel l = new JLabel("Имя");
            JLabel l1 = new JLabel("Фамилия");
            JLabel l2 = new JLabel("Отчество");
            JLabel l3 = new JLabel("Должность");

            l.setBounds(5,0,100,30);
            t.setBounds(5,30, 200,30);

            l1.setBounds(5,60,150,30);
            t1.setBounds(5,90, 200,30);

            l2.setBounds(5,120,150,30);
            t2.setBounds(5,150, 200,30);

            l3.setBounds(5,180,150,30);
            t3.setBounds(5,210, 200,30);

            JButton button1 = new JButton("Добавить");
            button1.setBounds(5, 270, 100, 30);

            frameStuff.add(t); frameStuff.add(t1); frameStuff.add(l); frameStuff.add(l1);
            frameStuff.add(t2); frameStuff.add(l2); frameStuff.add(t3); frameStuff.add(l3); frameStuff.add(button1);
            frameStuff.setSize(400,400);
            frameStuff.setLayout(null);
            frameStuff.setVisible(true);
            frameStuff.setLocationRelativeTo(null);

            button1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    List<JTextField> names = new ArrayList<>();
                    names.add(t);
                    names.add(t1);
                    names.add(t2);
                    names.add(t3);
                    Insert(names, 2);
                }
            });
        });

    }
}
public class AddStuff {
    public static void main(String args[]) throws SQLException {
        new Example();
      /*  SessionFactory factory = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            DAO<Room, Integer> dao = new RoomDAO(factory);
            //read(dao);
            //create(dao);
            //update(dao);
            //delete(dao);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (factory != null)
                factory.close();
        }*/
    }

    private static void read(DAO<Room, Integer> dao) {
        Room result = dao.read(1);
        System.out.println("Read: " + result);
    }

    private static void create(DAO<Room, Integer> dao) {
        Room subj = new Room();
        subj.setFloor(2);
        subj.setSquare(28.2);
        subj.setTemperature(36.6);
        subj.setHumidity(20.2);
        dao.create(subj);
    }

    private static void update(DAO<Room, Integer> roomDao) {
        final Room result = roomDao.read(1);
        result.setFloor(20);
        roomDao.update(result);
    }

    private static void delete(DAO<Room, Integer> roomDao) {
        Room room = roomDao.read(1);
        roomDao.delete(room);
    }
}
