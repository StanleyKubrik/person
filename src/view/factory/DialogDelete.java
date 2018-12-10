package view.factory;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class DialogDelete<T extends DialogDelete.DialogDeleteCallBack> extends JDialog implements IDialogFactory {
    public interface DialogDeleteCallBack {
        void callBackDelete(long id) throws SQLException;
    }

    public DialogDelete(T callBack) {
        setLayout(null);
        setTitle("Form Delete");
        setBackground(Color.LIGHT_GRAY);
        setBounds(300, 300, 300, 300);

        JTextField d_id = new JTextField();

        JButton delete = new JButton("Delete");
        JButton cancel = new JButton("Cancel");

        JLabel lbl_id = new JLabel("ID");

        d_id.setBounds(30, 45, 120, 20);

        delete.setBounds(160, 30, 100, 25);
        delete.setBackground(Color.WHITE);

        cancel.setBounds(160, 70, 100, 25);
        cancel.setBackground(Color.WHITE);

        lbl_id.setBounds(30, 30, 120, 10);

        add(d_id);

        add(delete);
        add(cancel);

        add(lbl_id);

        delete.addActionListener(e -> {
            try {
                callBack.callBackDelete(Long.parseLong(d_id.getText()));
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