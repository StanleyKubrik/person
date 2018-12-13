package view;

import control.Controler;
import control.IControler;
import model.Table;
import model.TableContract;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class Panel extends JPanel {
    private IControler iControler;
    private JTable tbl ;
    private JScrollPane scr ;
    private JButton create;
    private JButton read;
    private JButton update;
    private JButton delete;
    private JButton search;

    public Panel()
    {
        TableContract tabelConfig = new Table();
        iControler = new Controler(tabelConfig);
        setLayout(null);
        setBackground(Color.CYAN);
        tbl = new JTable((TableModel) tabelConfig);
        scr = new JScrollPane(tbl);
        scr.setBounds(10, 10, 400, 400);

        create =  new JButton("Create");
        read   =  new JButton("Read");
        update =  new JButton("Update");
        delete =  new JButton("Delete");
        search =  new JButton("Search");

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

        add(scr);
        add(create);
        add(read);
        add(update);
        add(delete);
        add(search);

        create.addActionListener(v-> iControler.create());
        read.addActionListener(v-> iControler.read());
        update.addActionListener(v-> iControler.update());
        delete.addActionListener(v-> iControler.delete());
        search.addActionListener(v-> iControler.search());
    }
}
