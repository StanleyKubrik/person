package view.factory;

import model.Person;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class DialogSearch<T extends DialogSearch.DialogSearchCallBack> extends JDialog implements IDialogFactory {
    public interface DialogSearchCallBack {
        void callBackSearch(Person person);
    }

    public DialogSearch(T callBack) {
        setLayout(null);
        setTitle("Form Search");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300, 300, 300, 300);

        JTextField d_ID = new JTextField();
        JTextField d_FName = new JTextField();
        JTextField d_LName = new JTextField();

        JButton search = new JButton("Search");
        JButton cancel = new JButton("Cancel");

        JLabel lbl_ID = new JLabel("ID");
        JLabel lbl_FName = new JLabel("FNAME");
        JLabel lbl_LName = new JLabel("LNAME");

        d_ID.setBounds(30, 150, 120, 20);
        d_FName.setBounds(30, 45, 120, 20);
        d_LName.setBounds(30, 95, 120, 20);

        search.setBounds(160, 30, 100, 25);
        search.setBackground(Color.WHITE);

        cancel.setBounds(160, 70, 100, 25);
        cancel.setBackground(Color.WHITE);

        lbl_ID.setBounds(30, 135, 120, 10);
        lbl_FName.setBounds(30, 30, 120, 10);
        lbl_LName.setBounds(30, 75, 120, 10);

        add(d_ID);
        add(d_FName);
        add(d_LName);

        add(search);
        add(cancel);

        add(lbl_ID);
        add(lbl_FName);
        add(lbl_LName);

        search.addActionListener(e -> {
            callBack.callBackSearch(new Person(
                    Long.parseLong(d_ID.getText()),
                    d_FName.getText(),
                    d_LName.getText()));
            setVisible(false);
        });
        cancel.addActionListener(e -> setVisible(false));
    }

    @Override
    public void setModal(boolean modal) {
        super.setModal(modal);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
}
