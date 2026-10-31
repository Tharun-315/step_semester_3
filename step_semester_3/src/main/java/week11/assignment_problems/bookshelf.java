package week11.assignment_problems;

public class bookshelf {

    static void shelf(int[] books) {

        for (int i = 1; i < books.length; i++) {

            int key = books[i];
            int j = i - 1;

            // Move bigger books to the right
            while (j >= 0 && books[j] > key) {

                books[j + 1] = books[j];
                j--;
            }

            // Place book in correct position
            books[j + 1] = key;

            System.out.print("After placing " + key + ": ");

            for (int k = 0; k < books.length; k++) {
                System.out.print(books[k]);

                if (k < books.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] books = {30, 10, 40, 20};

        shelf(books);

        // Own test input
        int[] books2 = {50, 20, 40, 10};

        System.out.println("\nOwn Test:");

        shelf(books2);
    }
}
