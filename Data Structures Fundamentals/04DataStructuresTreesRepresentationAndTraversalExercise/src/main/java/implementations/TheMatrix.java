package implementations;

import java.util.ArrayDeque;
import java.util.Deque;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char toBeReplaced;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.toBeReplaced = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
        char startChar = this.matrix[this.startRow][this.startCol];
        Deque<Position> stack = new ArrayDeque<>();
        stack.push(new Position(startRow, startCol));
        while (!stack.isEmpty()) {
            Position currentPosition = stack.pop();
            this.matrix[currentPosition.getRow()][currentPosition.getCol()] = this.fillChar;

            //up
            Position upPosition = new Position(currentPosition.getRow() - 1, currentPosition.getCol());
            if (isInBound(upPosition) && this.matrix[upPosition.getRow()][upPosition.getCol()] == startChar) {
                stack.push(upPosition);
            }

            //down
            Position downPosition = new Position(currentPosition.getRow() + 1, currentPosition.getCol());
            if (isInBound(downPosition) && this.matrix[downPosition.getRow()][downPosition.getCol()] == startChar) {
                stack.push(downPosition);
            }

            //left
            Position leftPosition = new Position(currentPosition.getRow(), currentPosition.getCol() - 1);
            if (isInBound(leftPosition) && this.matrix[leftPosition.getRow()][leftPosition.getCol()] == startChar) {
                stack.push(leftPosition);
            }

            //right
            Position rightPosition = new Position(currentPosition.getRow(), currentPosition.getCol() + 1);
            if (isInBound(rightPosition) && this.matrix[rightPosition.getRow()][rightPosition.getCol()] == startChar) {
                stack.push(rightPosition);
            }
        }
    }

    private boolean isInBound(Position position) {
        return 0 <= position.getRow() && position.getRow() < matrix.length
                && 0 <= position.getCol() && position.getCol() < matrix[0].length;
    }

    public String toOutputString() {
        StringBuffer sb = new StringBuffer();
        for (char[] row : matrix) {
            for (char c : row) {
                sb.append(String.valueOf(c));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return this.toOutputString();
    }

}
