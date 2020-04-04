import javax.swing.*;

public class DataViewer extends JFrame {

    public DataViewer() {
        setTitle("Data Viewer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocation(200, 200);
        add(new Panel());
        setVisible(true);

    }

    public static void main(String[] args) {
        WindowConstants window = new DataViewer();
    }
}
