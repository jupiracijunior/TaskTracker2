package org.example;

import com.sun.security.jgss.GSSUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TaskTracker {

    public static void main(String[] args) throws IOException {
        Json mapper = new Json(); // Gera o conversor json
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Converte json para objeto e salva em um objeto correspondente
        ManagerTask mt = new ManagerTask(mapper.toObject(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json")));

        // Reconhece e executa os comandos correspondentes
        switch (args[0]) {
            case "add":
                mt.add(args[1]);
                break;
            case "update":
                mt.update(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                mt.delete(Integer.parseInt(args[1]));
                break;
            case "mark-in-progress":
                mt.mark_in_progress(Integer.parseInt(args[1]));
                break;
            case "mark-done":
                mt.mark_done(Integer.parseInt(args[1]));
                break;
            case "list":
                try {
                    switch (args[1]) {
                        case "done":
                            System.out.println(mt.list_done());
                            break;
                        case "todo":
                            System.out.println(mt.list_todo());
                            break;
                        case "in-progress":
                            System.out.println(mt.list_in_progress());
                            break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(mt.list_all());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            default:
                System.out.println("Comando nao reconhecido.");
                break;
        }

        // Salva as alteracoes em um arquivo json
        FileOutputStream outStream = new FileOutputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json");
        outStream.write(mapper.toJson(mt).getBytes());
        outStream.flush();
        outStream.close();
    }

}