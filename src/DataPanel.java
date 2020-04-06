import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.table.TableColumn;
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

    private JTextField sliceY;
    private JTextField sliceX;
    private JCheckBox takeSlice;

    private JTextField filePath;
    private JTextField pythonPath;

    public void setPythonPath(JTextField pythonPath) {
        this.pythonPath = pythonPath;
    }

    public void setFilePath(JTextField filePath) {
        this.filePath = filePath;
    }

    private PythonAdapter adapter;
    private boolean havingFile;
    private String fileCSV;
    private int rowLeft, rowRight;
    private int colLeft, colRight;
    List<String> data;

    public DataPanel() {
        adapter = new PythonAdapter();

        setBackground(Color.lightGray);

        sliceY = new JTextField("срез по строчкам в формате \"l:r\"");
        sliceX = new JTextField("срез по столбцам в формате \"l:r\"");
        takeSlice = new JCheckBox();
        add(sliceY);
        add(sliceX);
        add(takeSlice);
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
        setVisible(false);

        removeAll();
        setLayout(new GridLayout(4 + data.size(), 1));
        add(sliceY);
        add(sliceX);
        add(takeSlice);
        add(new JLabel("DATA:"));
        for (String row : data) {
            JButton button = new JButton(row);
//            button.setPreferredSize(this.getSize());
            add(button);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("get_data")) {
            try {
                findCSV(filePath.getText());
                if (havingFile) {
                    if (takeSlice.isSelected()) {
                        data = adapter.getFrame(sliceY.getText(), sliceX.getText(), fileCSV, pythonPath.getText());
                    } else {
                        data = adapter.getData("show_all", fileCSV, pythonPath.getText());
                    }
                    showData();
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Cannot find csv file \"" + filePath.getText() + "\"");
            } catch (IOException ex) {
                System.out.println("Error trying to use python interpreter");
            }
        }
        if (e.getActionCommand().equals("frame")) {
            data = adapter.getFrame(sliceY.getText(), sliceX.getText(), fileCSV, pythonPath.getText());
            showData();
        }
        if (e.getActionCommand().equals("right")) {
            colLeft++;
            colRight++;
            showData();
        }
        if (e.getActionCommand().equals("left")) {
            if (colLeft > 0){
                colLeft--;
                colRight--;
                showData();
            }
        }
        if (e.getActionCommand().equals("up")) {
            if (rowLeft > 0) {
                rowLeft--;
                rowRight--;
                showData();
            }
        }
        if (e.getActionCommand().equals("down")) {
            rowLeft++;
            rowRight++;
            showData();
        }
    }
}
