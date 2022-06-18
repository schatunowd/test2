package forms;

import org.apache.fop.apps.FOPException;
import reports.ReportBuilder;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static forms.TableToXML.SaveXML;
import static javax.swing.JOptionPane.showMessageDialog;

public class MainForm {
    JMenu add, delete, toXML, report;
    JMenuItem itemAdd, roomAdd, personAdd,
            itemDel, roomDel, personDel,
            itemXML, roomXML,  personXML,
            itemReport, roomReport, personReport;

    public MainForm() {
        JFrame mainFrame = new JFrame("");
        add = new JMenu("Добавить");
        delete = new JMenu("Удалить");
        toXML = new JMenu("XML");
        report = new JMenu("Отчет");

        JMenuBar menuBar = new JMenuBar();

        itemAdd = new JMenuItem("предмет");
        roomAdd = new JMenuItem("помещение");
        personAdd = new JMenuItem("сотрудник");

        itemDel = new JMenuItem("предмет");
        roomDel = new JMenuItem("помещение");
        personDel = new JMenuItem("сотрудник");

        itemXML = new JMenuItem("предмет");
        roomXML = new JMenuItem("помещение");
        personXML = new JMenuItem("сотрудник");

        itemReport = new JMenuItem("предмет");
        roomReport = new JMenuItem("помещение");
        personReport = new JMenuItem("сотрудник");

        add.add(itemAdd);
        add.add(roomAdd);
        add.add(personAdd);

        delete.add(itemDel);
        delete.add(roomDel);
        delete.add(personDel);

        toXML.add(itemXML);
        toXML.add(roomXML);
        toXML.add(personXML);

        report.add(itemReport);
        report.add(roomReport);
        report.add(personReport);

        menuBar.add(add);
        menuBar.add(delete);
        menuBar.add(toXML);
        menuBar.add(report);

        mainFrame.setJMenuBar(menuBar);
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);

        itemXML.addActionListener(e ->
        {
           SaveXML("inventory", mainFrame);
        });
        personXML.addActionListener(e ->
        {
            SaveXML("persons", mainFrame);
        });
        roomXML.addActionListener(e ->
        {
            SaveXML("room", mainFrame);
        });
        itemAdd.addActionListener(e -> {
            List<String> labels = Arrays.asList("Название", "Вес", "Возраст", "Стоимость");
            new InsertForm("Добавление предмета", labels, 1).buildForm();

        });
        roomAdd.addActionListener(e -> {
            List<String> labels = Arrays.asList("Этаж", "Площадь", "Температура", "Влажность");
            new InsertForm("Добавление предмета", labels, 3).buildForm();
        });

        personAdd.addActionListener(e -> {
            List<String> labels = Arrays.asList("Имя", "Фамилия", "Отчество", "Должность");
            new InsertForm("Добавление предмета", labels, 2).buildForm();
        });

        itemReport.addActionListener(e -> {
            ReportBuilder.getReport("inventory");
        });

        roomReport.addActionListener(e -> {
            ReportBuilder.getReport("room");
        });

        personReport.addActionListener(e -> {
           ReportBuilder.getReport("persons");
        });
    }
}
