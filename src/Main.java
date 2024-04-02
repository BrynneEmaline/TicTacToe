import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[] pos = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',};
        Scanner scanner = new Scanner(System.in);
        int input;
        char turn = 'X';
        int currentTurn = 1;

        while (true) {
            printBoard(pos);
            System.out.println("Choose a position (1-9):");

            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Not a valid position. Must be an empty position 1-9.");
                    scanner.next();
                }
                input = scanner.nextInt();
                if (input >= 1 && input <= 9 && pos[input - 1] != 'X' && pos[input - 1] != 'O') {
                    pos[input - 1] = turn;
                    break;
                } else {
                    System.out.println("Invalid position or already taken.");
                }
            }

            if (pos[0] == turn && pos[1] == turn && pos[2] == turn
                    || pos[3] == turn && pos[4] == turn && pos[5] == turn
                    || pos[6] == turn && pos[7] == turn && pos[8] == turn
                    || pos[0] == turn && pos[4] == turn && pos[8] == turn
                    || pos[2] == turn && pos[4] == turn && pos[6] == turn
                    || pos[0] == turn && pos[3] == turn && pos[6] == turn
                    || pos[1] == turn && pos[4] == turn && pos[7] == turn
                    || pos[2] == turn && pos[5] == turn && pos[8] == turn) {
                printBoard(pos);
                System.out.println(turn + " is the winner!");
                break;
            }
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
            currentTurn++;
            if (currentTurn > 9) {
                System.out.println("It's a draw!");
                break;
            }
        }
    }

    static void printBoard(char[] pos) {
        System.out.println(" "+pos[6]+" "+"|"+" "+pos[7]+" "+"|"+" "+pos[8]+" ");
        System.out.println("---+---+---");
        System.out.println(" "+pos[3]+" "+"|"+" "+pos[4]+" "+"|"+" "+pos[5]+" ");
        System.out.println("---+---+---");
        System.out.println(" "+pos[0]+" "+"|"+" "+pos[1]+" "+"|"+" "+pos[2]+" ");
    }
}
