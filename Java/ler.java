import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ler {
    public static void main(String[] args) {
        String pythonScript = "trying.py";
        String[] parametros = {"ola", "mundo", "pelo", "python", "chamado", "pelo", "java"};

        try {
            List<String> command = new ArrayList<>();
            command.add("python");
            command.add(pythonScript);
            for (String i : parametros) {
                command.add(i);
            }

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            // Leitura da saída do processo Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Código de saída: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
