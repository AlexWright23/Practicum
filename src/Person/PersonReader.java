import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select the Person file to read");
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                System.out.printf("%-10s %-15s %-15s %-10s %-4s\n", "ID", "First Name", "Last Name", "Title", "YOB");
                System.out.println("===============================================================");
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    System.out.printf("%-10s %-15s %-15s %-10s %-4s\n", parts[0], parts[1], parts[2], parts[3], parts[4]);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}


