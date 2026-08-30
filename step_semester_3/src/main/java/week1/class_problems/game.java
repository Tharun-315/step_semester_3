import java.util.*;

public class game {

    static String playRound(String player, String computer) {
        if (player.equals(computer))
            return "Draw";

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
                (player.equals("Paper") && computer.equals("Rock")) ||
                (player.equals("Scissors") && computer.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int wins = 0, losses = 0, draws = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Rock, Paper or Scissors: ");
            String player = sc.next();

            String[] moves = {"Rock", "Paper", "Scissors"};
            String computer = moves[r.nextInt(3)];

            String result = playRound(player, computer);

            System.out.println("Computer: " + computer);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        double percentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + percentage + "%");
    }
}