import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private JTextField filePathText;
    private JTextField pythonPathText;

    public ControlPanel(ActionListener dataShower) {
        setBackground(Color.gray);

        filePathText = new JTextField("");
        pythonPathText = new JTextField("");


        JButton findButton = new JButton("Показать данные"/*new ImageIcon("images/get_data.png")*/);
        findButton.setBackground(Color.red);
        findButton.setActionCommand("get_data");
        findButton.addActionListener(dataShower);

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

        setLayout(new GridLayout(2, 6));

        add(new Label("введите путь до файла"));
        add(findButton);
        add(new Label("введите путь до интерпретатора"));
        add(new Label(""));
        add(upButton);
        add(new Label(""));

        add(filePathText);
        add(new Label(""));
        add(pythonPathText);
        add(leftButton);
        add(downButton);
        add(rightButton);
    }

    public JTextField getPythonPathText() {
        return pythonPathText;
    }

    public JTextField getFilePathText() {
        return filePathText;
    }
}
