import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ControlPanel extends JPanel {
    private JTextField textButton;

    public ControlPanel(ActionListener dataShower) {
        setBackground(Color.gray);

        textButton = new JTextField("введите путь до файла", 25);

        JButton findButton = new JButton(new ImageIcon("images/find.png"));
        findButton.setActionCommand("confirm_file_path");
        findButton.addActionListener(dataShower);

        JButton columnsButton = new JButton("Показать имена столбцов", new ImageIcon("images/show_columns.png"));
        columnsButton.setActionCommand("show_columns");
        columnsButton.addActionListener(dataShower);

        JButton leftButton = new JButton("влево");
        leftButton.setActionCommand("left");
        leftButton.addActionListener(dataShower);

        JButton rightButton = new JButton("вправо");
        rightButton.setActionCommand("right");
        rightButton.addActionListener(dataShower);

        JButton upButton = new JButton("вверх");
        upButton.setActionCommand("up");
        upButton.addActionListener(dataShower);

        JButton downButton = new JButton("вниз");
        downButton.setActionCommand("down");
        downButton.addActionListener(dataShower);

        add(textButton);
        add(findButton);
        add(columnsButton);
        add(rightButton);
        add(leftButton);
        add(upButton);
        add(downButton);
    }

    public JTextField getTextButton() {
        return textButton;
    }
}
