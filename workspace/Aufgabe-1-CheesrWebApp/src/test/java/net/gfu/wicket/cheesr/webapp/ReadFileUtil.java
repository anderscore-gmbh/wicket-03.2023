package net.gfu.wicket.cheesr.webapp;

import org.junit.Test;

import java.io.*;

public class ReadFileUtil {

    @Test
    public void readFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        BufferedReader reader;
        try (InputStream resourceAsStream = classLoader.getResourceAsStream("random.txt")) {
            reader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String file = classLoader.getResource("pdfs/debugger.pdf").getFile();

        File file1 = new File(classLoader.getResource("pdfs/debugger.pdf").getFile());
        System.out.println("Hallo Welt!");
    }

}
