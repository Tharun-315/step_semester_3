package week11.practice_problems;

import java.util.HashSet;
public class transaction {
    static boolean hasDuplicate(String[] transactionIds) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < transactionIds.length; i++) {

            if (set.contains(transactionIds[i])) {
                return true;
            }

            set.add(transactionIds[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        String[] ids1 = {
                "TXN1001", "TXN1002", "TXN1003",
                "TXN1002", "TXN1004"
        };

        String[] ids2 = {
                "TXN2001", "TXN2002", "TXN2003"
        };

        System.out.println(hasDuplicate(ids1));
        System.out.println(hasDuplicate(ids2));
    }
}
