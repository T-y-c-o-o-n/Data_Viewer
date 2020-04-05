/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestWindow extends JFrame {

    public TestWindow() {
        setTitle("Data Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocation(200, 200);
        SouthPanel dataShower = new SouthPanel();
        add(dataShower, BorderLayout.CENTER);
        add(new NorthPanel(dataShower), BorderLayout.NORTH);

        setVisible(true);
    }

    public static class NorthPanel extends JPanel {
        public NorthPanel(ActionListener shower) {
            setBackground(Color.gray);

            JTextField textButton = new JTextField("введите путь до файла", 25);

            JButton findButton = new JButton(new ImageIcon("images/get_data.png"));
            findButton.setActionCommand("confirm file path");
            findButton.addActionListener(shower);

            JButton columnsButton = new JButton("Показать имена столбцов", new ImageIcon("images/show_columns.png"));
            columnsButton.setActionCommand("show columns");
            columnsButton.addActionListener(shower);

            JButton rightButton = new JButton("вправо");
            rightButton.setActionCommand("right");
            rightButton.addActionListener(shower);

            JButton leftButton = new JButton("влево");
            leftButton.setActionCommand("left");
            leftButton.addActionListener(shower);

            JButton upButton = new JButton("вверх");
            upButton.setActionCommand("up");
            upButton.addActionListener(shower);

            JButton downButton = new JButton("вниз");
            downButton.setActionCommand("down");
            downButton.addActionListener(shower);

            add(textButton);
            add(findButton);
            add(columnsButton);
            add(rightButton);
            add(leftButton);
            add(upButton);
            add(downButton);
        }
    }

    public static class SouthPanel extends JPanel implements ActionListener {
        private int rows, cols;
        private int rowBegin, colBegin;
        private String[][] data = new String[rows][cols];

        public SouthPanel() {
            rowBegin = 0;
            rows = 4;
            colBegin = 1;
            cols = 6;
            setBackground(Color.cyan);

            showData();
        }

        private void showData() {
            removeAll();
            setVisible(false);
            setLayout(new GridLayout(rows + 1, cols + 1, 10, 10));
            add(new JLabel("DATA:"));
            for (int j = colBegin; j < colBegin + cols; j++) {
                add(new JButton("name" + j));
            }
            for (int i = rowBegin; i < rowBegin + rows; i++) {
                add(new JButton("" + i));
                for (int j = colBegin; j < colBegin + cols; j++) {
                    add(new JButton("elem " + i + " " + j));
                }
            }
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("confirm file path")) {
            }
            if (e.getActionCommand().equals("show columns")) {
            }
            if (e.getActionCommand().equals("right")) {
                colBegin++;
                showData();
            }
            if (e.getActionCommand().equals("left")) {
                if (colBegin > 1){
                    colBegin--;
                    showData();
                }
            }
            if (e.getActionCommand().equals("up")) {
                if (rowBegin > 0) {
                    rowBegin--;
                    showData();
                }
            }
            if (e.getActionCommand().equals("down")) {
                rowBegin++;
                showData();
            }
        }
    }

    public static void main(String[] args) {
        new TestWindow();
    }
}
*/
