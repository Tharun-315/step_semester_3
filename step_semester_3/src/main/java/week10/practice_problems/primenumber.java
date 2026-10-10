package week10.practice_problems;


import java.util.Scanner;

public class primenumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            boolean isPrime = true;

            for (int i = 2; i <= num / i; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(num + " is prime");
            } else {
                System.out.println(num + " is not prime");
            }
        }

        sc.close();
    }
}

