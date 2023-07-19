package UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class sendSQL {

    public void send(User user) {
        String pythonScript = "src/main/Enviar/send.py";
        String nome = user.getNome();
        String username = user.getUserName();
        String email = user.getEmail();
        String senha = user.getSenha();

        try {
            List<String> command = new ArrayList<>();
            command.add("python");
            command.add(pythonScript);
            command.add(nome);
            command.add(username);
            command.add(email);
            command.add(senha);

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
