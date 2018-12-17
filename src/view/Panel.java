package view;

import control.Controller;
import control.IControler;
import model.Table;
import model.TableContract;
import model.filereader.FileReader;
import model.filereader.FileReaderContract;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.FileNotFoundException;

public class Panel extends JPanel {
    private IControler iControler;
    private JTable tbl ;
    private JScrollPane scr ;
    private JButton create;
    private JButton read;
    private JButton update;
    private JButton delete;
    private JButton search;
    private JButton imp;
    private JButton exp;

    public Panel() throws FileNotFoundException {
        TableContract tabelConfig = new Table();
        iControler = new Controller(tabelConfig);
        setLayout(null);
        setBackground(Color.gray);
        tbl = new JTable((TableModel) tabelConfig);
        scr = new JScrollPane(tbl);
        scr.setBounds(10, 10, 400, 435);

        create =  new JButton("Create");
        read   =  new JButton("Read");
        update =  new JButton("Update");
        delete =  new JButton("Delete");
        search =  new JButton("Search");
        imp = new JButton("Import");
        exp = new JButton("Export");

        create.setBounds(600, 100, 100, 40);
        create.setBackground(Color.WHITE);

        read.setBounds(600, 150, 100, 40);
        read.setBackground(Color.WHITE);

        update.setBounds(600, 200, 100, 40);
        update.setBackground(Color.WHITE);

        delete.setBounds(600, 250, 100, 40);
        delete.setBackground(Color.WHITE);

        search.setBounds(600, 300, 100, 40);
        search.setBackground(Color.WHITE);

        imp.setBounds(420, 10, 100, 20);
        imp.setBackground(Color.PINK);

        exp.setBounds(530, 10, 100, 20);
        exp.setBackground(Color.PINK);

        add(scr);
        add(create);
        add(read);
        add(update);
        add(delete);
        add(search);
        add(imp);
        add(exp);

        create.addActionListener(v-> iControler.create());
        read.addActionListener(v-> iControler.read());
        update.addActionListener(v-> iControler.update());
        delete.addActionListener(v-> iControler.delete());
        search.addActionListener(v-> iControler.search());
        imp.addActionListener(v-> iControler.imp());
        exp.addActionListener(v-> iControler.exp());
    }
}
