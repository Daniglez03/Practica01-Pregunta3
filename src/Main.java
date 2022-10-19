import java.io.*;

public class Main {
    public static void main(String[] args){
        File file = new File("./data/reader.txt");
        File fileFichero = new File("./data/fichero.txt");
        try {

            if (!fileFichero.exists()) {
                System.out.println(fileFichero + " no existe.");
            }else {
                // Escribir el resultado del comando hecho en fichero.txt y mostrarlo en reader.txt a través del bash
                ProcessBuilder builders = new ProcessBuilder(
                        "C:\\Users\\Dani\\AppData\\Local\\Programs\\Git\\git-bash.exe ",
                                "-c",
                                "cat ./data/fichero.txt | wc > ./data/reader.txt");
                builders.start();
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String linea;
                while((linea=br.readLine())!=null) {
                    System.out.println("Lines:   Words:   Bytes:");
                    System.out.println(linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero.\nCreando " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
