package API_test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class threadLogger {

    private static threadLogger instance = new threadLogger();
    private File logFile = new File("logs/log.txt");
    private PrintWriter writer;

    private threadLogger() {
        try {
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized threadLogger getInstance() {
        return instance;
    }

    public void logLocID(int loc_id) {
        writer.println("Got JSON for id: " + String.valueOf(loc_id));
    }

}
