import javax.swing.*;
import java.awt.*;

public class DataViewer extends JFrame {

    public DataViewer() {
        setTitle("Data Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocation(200, 200);

        DataPanel dataPanel = new DataPanel();
        add(dataPanel, BorderLayout.CENTER);
        ControlPanel controlPanel = new ControlPanel(dataPanel);
        add(controlPanel, BorderLayout.NORTH);

        dataPanel.setTextButton(controlPanel.getTextButton());

        setVisible(true);
    }

    public static void main(String[] args) {
        WindowConstants window = new DataViewer();
    }
}
