class IdCard {
    String name;
    int booksIssued;

    // Constructor
    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class library {
    public static void main(String[] args) {

        // First object
        IdCard ravi = new IdCard("Ravi", 0);

        // Second variable points to the same object
        IdCard duplicate = ravi;

        // Change using second variable
        duplicate.booksIssued = 3;

        // Print using first variable
        System.out.println(
                "Ravi's booksIssued (via first variable): "
                        + ravi.booksIssued
        );

        // Check whether both variables refer to same object
        System.out.println(
                "duplicate == ravi: " + (duplicate == ravi)
        );

        // Create a separate object
        IdCard separate = new IdCard("Ravi", 3);

        // Check whether separate object is same as first object
        System.out.println(
                "separate == ravi: " + (separate == ravi)
        );
    }
}