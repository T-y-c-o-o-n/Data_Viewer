import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PythonAdapter {

    PythonAdapter() {}

    public List<String> getData(String command, String fileCSV, String pathToPython) {
        try {
            ProcessBuilder debuilder = new ProcessBuilder(pathToPython + "\\python", "src\\reader.py", command, fileCSV);
            debuilder.redirectErrorStream(true);
            Process proc = debuilder.start();

            List<String> result = new ArrayList<>();

            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//            System.out.println();
            String input;
            while ((input = br.readLine()) != null) {
//                System.out.println(input);
                result.add(input);
            }
//            System.out.println();

            proc.waitFor();
            proc.destroy();

            return result;
        } catch (InterruptedException ex) {
            System.out.println("Error: running of command was interrupted");
        } catch (IOException ex) {
            System.out.println("Error: cannot read the command");
        }

        throw new RuntimeException();
    }

    /**
    * It's only for testing adapter directly
     * args[0] - expected command for adapter
     * args[1] - expected path to csv file
     * args[2] - expected directory with python interpreter
     */
    public static void main(String[] args) {
        String command = args[0];
        String fileCSV = args[1];
        String pathToPython = args[2];
        new PythonAdapter().getData(command, fileCSV, pathToPython);
    }
}
