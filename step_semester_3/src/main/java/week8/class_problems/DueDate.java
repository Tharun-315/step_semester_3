import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract LocalDate getDueDate(LocalDate currentDate);
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    @Override
    LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    @Override
    LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    @Override
    LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class DueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LibraryItem[] items = new LibraryItem[n];

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            String[] parts = line.split(" ", 2);

            String itemType = parts[0];
            String title = parts[1].trim();

            // Remove quotation marks if present
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            if (itemType.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (itemType.equals("DVD")) {
                items[i] = new DVD(title);
            } else {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {
            LocalDate dueDate = item.getDueDate(currentDate);

            System.out.println(item.title + ": " + dueDate);
        }

        sc.close();
    }
}