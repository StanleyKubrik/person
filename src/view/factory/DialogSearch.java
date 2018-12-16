package view.factory;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class DialogSearch<T extends DialogSearch.DialogSearchCallBack> extends JDialog implements IDialogFactory {
    public interface DialogSearchCallBack {
        void callBackSearch(Long id, String fname, String lname, Long age) throws SQLException;
    }

    public DialogSearch(T callBack) {
        setLayout(null);
        setTitle("Form Search");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(300, 300, 300, 300);

        JTextField d_ID = new JTextField();
        JTextField d_FName = new JTextField();
        JTextField d_LName = new JTextField();
        JTextField d_Age = new JTextField();

        JButton search = new JButton("Search");
        JButton cancel = new JButton("Cancel");

        JLabel lbl_ID = new JLabel("ID");
        JLabel lbl_FName = new JLabel("FNAME");
        JLabel lbl_LName = new JLabel("LNAME");
        JLabel lbl_Age = new JLabel("AGE");

        d_ID.setBounds(30, 35, 120, 20);
        d_FName.setBounds(30, 85, 120, 20);
        d_LName.setBounds(30, 135, 120, 20);
        d_Age.setBounds(30, 185, 120, 20);

        search.setBounds(160, 30, 100, 25);
        search.setBackground(Color.WHITE);

        cancel.setBounds(160, 70, 100, 25);
        cancel.setBackground(Color.WHITE);

        lbl_ID.setBounds(30, 20, 120, 10);
        lbl_FName.setBounds(30, 70, 120, 10);
        lbl_LName.setBounds(30, 120, 120, 10);
        lbl_Age.setBounds(30, 170, 120, 10);

        add(d_ID);
        add(d_FName);
        add(d_LName);
        add(d_Age);

        add(search);
        add(cancel);

        add(lbl_ID);
        add(lbl_FName);
        add(lbl_LName);
        add(lbl_Age);

        search.addActionListener(e -> {
            try {
                callBack.callBackSearch(Long.parseLong(d_ID.getText()),
                        d_FName.getText(),
                        d_LName.getText(),
                        Long.parseLong(d_Age.getText()));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
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
