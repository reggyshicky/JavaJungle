import java.util.Scanner;
import java.util.HashMap;

public class ProgrammingAssigment2 {
    static HashMap<String, String[]> library = new HashMap<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("===============================");
        System.out.println("    Welcome to the library     ");
        System.out.println("===============================");

        while (choice != 4) {
            printMenu();
            try {
                choice = Integer.parseInt(scan.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }
            switch (choice) {
                case 1: addBook();   break;
                case 2: borrowBook(); break;
                case 3: returnBook(); break;
                case 4: System.out.println("Thank you for using the library. Goodbye!"); break;
                default: System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
        scan.close();
    }

    static void printMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = scan.nextLine().trim();
        System.out.print("Enter author: ");
        String author = scan.nextLine().trim();
        System.out.print("Enter quantity: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scan.nextLine().trim());
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity. Please enter a whole number.");
            return;
        }
        if (library.containsKey(title.toLowerCase())) {
            // Book Exists - update quantity
            String[] existing = library.get(title.toLowerCase());
            int updatedQuantity = Integer.parseInt(existing[1]) + quantity;
            existing[1] = String.valueOf(updatedQuantity);
            System.out.println("Book already exists. Quantity updated to " + updatedQuantity + ".");
        } else {
            // New Book - add to library
            library.put(title.toLowerCase(), new String[]{author, String.valueOf(quantity)});
            System.out.println('"' + title + '"' + " by " + author + " added successfully.");
        }
    }

    static void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = scan.nextLine().trim();
        System.out.print("Enter number of books to borrow: ");
        int amount;
        try {
            amount = Integer.parseInt(scan.nextLine().trim());
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a whole number.");
            return;
        }
        if (library.containsKey(title.toLowerCase())) {
            String[] bookData = library.get(title.toLowerCase());
            int available = Integer.parseInt(bookData[1]);
            if (available >= amount) {
                // Enough copies - deduct and confirm
                bookData[1] = String.valueOf(available - amount);
                System.out.println("Successfully borrowed " + amount + " copy/copies.");
                System.out.println("Remaining copies: " + bookData[1]);
            } else {
                // Not enough copies
                System.out.println("Sorry, only " + available + " copy/copies available.");
            }
        } else {
            System.out.println('"' + title + '"' + " is not found in the library.");
        }
    }

    static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scan.nextLine().trim();
        System.out.print("Enter number of books to return: ");
        int amount;
        try {
            amount = Integer.parseInt(scan.nextLine().trim());
            if (amount <= 0) {
                System.out.println("Amount must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a whole number.");
            return;
        }
        if (library.containsKey(title.toLowerCase())) {
            // Book belongs to library - add back quantity
            String[] bookData = library.get(title.toLowerCase());
            int updatedQty = Integer.parseInt(bookData[1]) + amount;
            bookData[1] = String.valueOf(updatedQty);
            System.out.println("Successfully returned " + amount + " copy/copies.");
            System.out.println("Updated copies available: " + updatedQty);
        } else {
            System.out.println('"' + title + '"' + " does not belong to this library. Return rejected.");
        }
    }
}
