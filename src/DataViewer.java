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
//        new PythonAdapter().run("show_all",
//                "D:\\Documents\\proga\\javka\\Data_Viewer\\tables\\table.csv",
//                "C:\\Users\\User\\AppData\\Local\\Programs\\Python\\Python38-32");
    }
}
