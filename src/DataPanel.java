import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class DataPanel extends JPanel implements ActionListener {
    private static String myPythonPath;
    /**
     * Here you should paste path to python interpreter for testing adapter
     * It doesn't matter for project
     */
    static {
        myPythonPath = "C:\\Users\\User\\AppData\\Local\\Programs\\Python\\Python38-32";
    }

    private JTextField textButton;

    public void setTextButton(JTextField textButton) {
        this.textButton = textButton;
    }

    private PythonAdapter adapter;
    private boolean havingFile;
    private String fileCSV;
    private int rows, cols;
    private int rowBegin, colBegin;
    List<String> data;

    public DataPanel() {
        adapter = new PythonAdapter();

        setBackground(Color.cyan);
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

    private void showData() {
        removeAll();
        setVisible(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("DATA:"));
        for (String row : data) {
            JButton button = new JButton(row);
            button.setPreferredSize(this.getSize());
            add(button);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm_file_path")) {
            try {
                findCSV(textButton.getText());
                if (havingFile) {
                    data = adapter.getData("show_all", fileCSV, myPythonPath);
                    showData();
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Cannot find csv file \"" + textButton.getText() + "\"");
            } catch (IOException ex) {
                System.out.println("Error trying to use python interpreter");
            }
        }
        if (e.getActionCommand().equals("show_columns")) {
            if (havingFile) {
                data = adapter.getData("columns", fileCSV, myPythonPath);
            }
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
