import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Panel extends JPanel implements ActionListener {
    private static String myPythonPath;
    /**
     * Here you should paste path to python interpreter for testing adapter
     * It doesn't matter for project
     */
    static {
        myPythonPath = "C:\\Users\\User\\AppData\\Local\\Programs\\Python\\Python38-32";
    }

    private PythonAdapter adapter;
    private boolean havingFile;
    private JTextField textButton;
    private String fileCSV;

    public Panel() {
        adapter = new PythonAdapter();
        havingFile = false;

        setBackground(Color.gray);

        //Добавляем BoxLayout
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        textButton = new JTextField("введите путь до файла", 25);

        JButton columnsButton = new JButton("Показать имена столбцов", new ImageIcon("images/show_columns.png"));
        columnsButton.setActionCommand("show columns");
        columnsButton.addActionListener(this);

        JButton findButton = new JButton(new ImageIcon("images/find.png"));
        findButton.setActionCommand("confirm file path");
        findButton.addActionListener(this);

        //Выравниваем по центру по оси X
        //button1.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(textButton);
        add(findButton);
        add(columnsButton);
    }

    private void findCSV(String path) throws IOException {
        havingFile = true;
        fileCSV = path;


        /*File file = new File(path);
        if (file.createNewFile()) {
            havingFile = true;
            fileCSV = path;
        } else {
            havingFile = false;
            throw new FileNotFoundException();
        }*/
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm file path")) {
            try {
                findCSV(textButton.getText());
                if (havingFile) {
                    adapter.run("show_all", fileCSV, myPythonPath);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Cannot find csv file \"" + textButton.getText() + "\"");
            } catch (IOException ex) {
                System.out.println("Error trying to use python interpreter");
            }
        }
        if (e.getActionCommand().equals("show columns")) {
            if (havingFile) {
                adapter.run("columns", fileCSV, myPythonPath);
            }
        }
    }
}
