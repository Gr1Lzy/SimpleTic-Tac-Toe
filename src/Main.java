import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    static String[][] makeTwoDimensionalArray() {
        String[][] twoDimensionalArray = new String[3][3];
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray.length; j++) {
                twoDimensionalArray[i][j] = " ";
            }
        }
        return twoDimensionalArray;
    }
    static void startGame() {
        Scanner scanner = new Scanner(System.in);
        String[][] twoDimensionalArray = makeTwoDimensionalArray();
        boolean bool = true;
        int count = 0;
        conclusion(twoDimensionalArray);

        while (checkResult(twoDimensionalArray, count)){
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (x > 3 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (twoDimensionalArray[x - 1][y - 1].equals("X") || twoDimensionalArray[x - 1][y - 1].equals("O")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else if (count % 2 == 0) {
                    twoDimensionalArray[x - 1][y - 1] = "X";
                    count++;
                    conclusion(twoDimensionalArray);
                } else {
                    twoDimensionalArray[x - 1][y - 1] = "O";
                    count++;
                    conclusion(twoDimensionalArray);
                }

            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    static void conclusion(String[][] array) {
        System.out.println("---------");
        System.out.println("| " + array[0][0] + " " + array[0][1] + " " + array[0][2] + " |");
        System.out.println("| " + array[1][0] + " " + array[1][1] + " " + array[1][2] + " |");
        System.out.println("| " + array[2][0] + " " + array[2][1] + " " + array[2][2] + " |");
        System.out.println("---------");
    }

    static boolean checkResult(String[][] array, int turn) {
        String[] lines = new String[8];
        int xWin = 0;
        int oWin = 0;
        lines[0] = array[0][0] + array[0][1] + array[0][2];
        lines[1] = array[1][0] + array[1][1] + array[1][2];
        lines[2] = array[2][0] + array[2][1] + array[2][2];
        lines[3] = array[0][0] + array[1][0] + array[2][0];
        lines[4] = array[0][1] + array[1][1] + array[2][1];
        lines[5] = array[0][2] + array[1][2] + array[2][2];
        lines[6] = array[0][0] + array[1][1] + array[2][2];
        lines[7] = array[0][2] + array[1][1] + array[2][0];

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("XXX"))
                xWin++;
            if (lines[i].equals("OOO"))
                oWin++;
        }

        if (xWin == 1 && oWin == 0) {
            System.out.println("X wins");
            return false;
        } else if (xWin == 0 && oWin == 1) {
            System.out.println("O wins");
            return false;
        } else if (turn >= 9) {
            System.out.println("Draw");
            return false;

        }
        return true;
    }
}