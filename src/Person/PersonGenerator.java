

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        boolean moreData = true;

        while (moreData) {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (Mr., Mrs., etc.)");
            int yearOfBirth = SafeInput.getInt(in, "Enter Year of Birth");

            records.add(String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth));

            moreData = SafeInput.getYNConfirm(in, "Do you want to add another person?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the filename to save records");
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Records saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing the file: " + e.getMessage());
        }
    }
}
