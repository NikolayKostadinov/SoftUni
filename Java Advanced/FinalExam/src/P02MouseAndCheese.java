import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02MouseAndCheese {
    private static Scanner scan = new Scanner(System.in);
    private static Position playersPosition = new Position();
    private static final char PLAYER_SYMBOL = 'M';
    private static int cheeseEaten = 0;

    public static void main(String[] args) {
        int matrixSize = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[matrixSize][matrixSize];
        readMatrix(matrix);

        String command = scan.nextLine();
        while (!"end".equals(command)) {
            if (!executeCommand(command, matrix)) {
                System.out.println("Where is the mouse?");
                break;
            }
            command = scan.nextLine();
        }

        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }

        print(matrix);
    }

    private static boolean executeCommand(String command, char[][] matrix) {
        matrix[playersPosition.row][playersPosition.col] = '-';
        Position newPosition = calculateNewPosition(command, playersPosition);

        if (!isInMatrix(newPosition, matrix.length)) {
            return false;
        }

        char currentSymbol = matrix[newPosition.row][newPosition.col];
        if (currentSymbol == 'c') {
            cheeseEaten++;
        } else if (currentSymbol == 'B') {
            playersPosition.copy(newPosition);
            return executeCommand(command, matrix);
        }

        matrix[newPosition.row][newPosition.col] = PLAYER_SYMBOL;
        playersPosition.copy(newPosition);
        return true;
    }

    private static boolean isInMatrix(Position cookPosition, int size) {
        return cookPosition.row >= 0 && cookPosition.row < size
                && cookPosition.col >= 0 && cookPosition.col < size;
    }

    private static void readMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] row = scan.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = row[j];
                if (row[j] == PLAYER_SYMBOL) {
                    playersPosition = new Position(i, j);
                }
            }
        }
    }

    private static Position calculateNewPosition(String command, Position position) {
        Position newPosition = new Position(position.row, position.col);

        switch (command) {
            case "up":
                newPosition.row = newPosition.row - 1;
                break;
            case "down":
                newPosition.row = newPosition.row + 1;
                break;
            case "left":
                newPosition.col = newPosition.col - 1;
                break;
            case "right":
                newPosition.col = newPosition.col + 1;
                break;
        }

        return newPosition;
    }

    private static void print(char[][] screen) {
        System.out.println(Arrays.stream(screen).map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static class Position {
        int row;
        int col;

        public Position() {
            this(0, 0);
        }

        public void copy(Position position) {
            this.row = position.row;
            this.col = position.col;
        }

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
