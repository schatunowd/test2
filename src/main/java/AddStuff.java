import dao.*;
import forms.InsertForm;
import forms.MainForm;
import forms.TableToXML;
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
import java.util.Arrays;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;


public class AddStuff {
    public static void main(String args[]) throws SQLException {
        new MainForm();
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
