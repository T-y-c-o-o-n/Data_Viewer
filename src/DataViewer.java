import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class DataViewer extends JFrame {

    public DataViewer() {
        setTitle("Data Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 320);
        setLocation(400, 400);
        setVisible(true);
        add(new Panel(Color.blue));
    }

    public static void main(String[] args) {
        WindowConstants window = new DataViewer();
    }
}
