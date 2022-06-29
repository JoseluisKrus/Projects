import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {

        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Enter your placement (1-9):");
            int playerPosition = scanner.nextInt();
            while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
                System.out.println("Position taken");
                playerPosition = scanner.nextInt();
            }
            placePiece(gameBoard, playerPosition, "Player");
            String result = checkWinner();

            if (result.length() > 0) {
                printGameBoard(gameBoard);
                System.out.println(result);
                break;
            }

            int cpuPosition = random.nextInt(9) + 1;
            while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
                cpuPosition = random.nextInt(9) + 1;
            }

            placePiece(gameBoard, cpuPosition, "Cpu");
            printGameBoard(gameBoard);
            result = checkWinner();

            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }

    public static String checkWinner() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);

        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);

        List<Integer> crossLeftToRight = Arrays.asList(1, 5, 9);
        List<Integer> crossRightToLeft = Arrays.asList(7, 5, 3);


        List<List<Integer>> winingConditions = new ArrayList<>();

        winingConditions.add(topRow);
        winingConditions.add(midRow);
        winingConditions.add(bottomRow);
        winingConditions.add(leftCol);
        winingConditions.add(midCol);
        winingConditions.add(rightCol);
        winingConditions.add(crossLeftToRight);
        winingConditions.add(crossRightToLeft);

        for (List l : winingConditions) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins! Sorry..";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Draw!";
            }
        }
        return "";
    }

    private static void placePiece(char[][] gameBoard, int position, String user) {
        char symbol = ' ';
        if (user.equals("Player")) {
            symbol = 'X';
            playerPositions.add(position);
        } else if (user.equals("Cpu")) {
            symbol = 'O';
            cpuPositions.add(position);
        }


        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    private static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
