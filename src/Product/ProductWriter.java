import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        boolean moreData = true;

        while (moreData) {
            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            products.add(String.format("%s, %s, %s, %.2f", id, name, description, cost));

            moreData = SafeInput.getYNConfirm(in, "Do you want to add another product?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the filename to save products");
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String product : products) {
                writer.write(product + "\n");
            }
            System.out.println("Products saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}