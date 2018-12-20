package view;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Frame extends JFrame {

    public Frame() throws HeadlessException, FileNotFoundException {
        setBounds(400, 150, 800, 500);
        setTitle("model.Person V1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Panel());
        setVisible(true);
    }
}
