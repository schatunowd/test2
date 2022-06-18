package forms;

import dao.DAO;
import dao.InventoryDAO;
import dao.PersonsDAO;
import dao.RoomDAO;
import model.Inventory;
import model.Persons;
import model.Room;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class InsertForm
{
    private String titleName;
    private List<String> Labels;
    private int Param;
    public InsertForm(String title, List<String> labels, int param)
    {
        titleName = title;
        Labels = labels;
        Param = param;
    }
    public void buildForm()
    {
        JFrame frameStuff = new JFrame(titleName);
        JTextField t = new JTextField(), t1 = new JTextField(), t2 = new JTextField(), t3 = new JTextField();
        JLabel l = new JLabel(Labels.get(0));
        JLabel l1 = new JLabel(Labels.get(1));
        JLabel l2 = new JLabel(Labels.get(2));
        JLabel l3 = new JLabel(Labels.get(3));

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
            Insert(names, Param);
        });
    }
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
}