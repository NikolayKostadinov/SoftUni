package L02MultidimensionalArraysExercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int playerLife = 18500;
        double heiganLife = 3000000;
        char[][] playGround = new char[15][15];
        Position playerPosition = new Position(7, 7);
        boolean heatedPrevTime = false;
        String spell = "";
        double heiganDamage = Double.parseDouble(scan.nextLine());

        while (playerLife > 0 && heiganLife > 0) {
            heiganLife -= heiganDamage;
            String[] tokens = scan.nextLine().split("\\s");
            spell = tokens[0];
            int hitRow = Integer.parseInt(tokens[1]);
            int hitCol = Integer.parseInt(tokens[2]);
            drawDamageZone(hitRow, hitCol, playGround);
            if (heatedPrevTime) {
                playerLife -= 3500;
            }

            if (playerIsHit(playerPosition, playGround)) {
                playerLife -= calculateDamage(spell);
                heatedPrevTime = spell.equals("Cloud");
            }

            playGround = new char[15][15];
        }

        DecimalFormat df = new DecimalFormat();

        if (heiganLife <= 0){
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganLife);
        }

        if (playerLife <= 0){
            if (spell.equals("Cloud")) spell = "Plague Cloud";
            System.out.printf("Player: Killed by %s\n", spell);
        } else {
            System.out.printf("Player: %d\n", playerLife);
        }

        System.out.printf("Final position: %s", playerPosition);
    }

    private static boolean playerIsHit(Position playerPosition, char[][] playGround) {

        if (playGround[playerPosition.row][playerPosition.col] == 'x') {
            //up
            if (isInBoard(playerPosition.row - 1, playerPosition.col, playGround)
            && playGround[playerPosition.row-1][playerPosition.col] != 'x'){
                playerPosition.row -= 1;
                return false;
            }

            //right
            if (isInBoard(playerPosition.row, playerPosition.col + 1, playGround)
            && playGround[playerPosition.row][playerPosition.col + 1] != 'x'){
                playerPosition.col += 1;
                return false;
            }

            //down
            if (isInBoard(playerPosition.row +1, playerPosition.col, playGround)
            && playGround[playerPosition.row + 1][playerPosition.col] != 'x'){
                playerPosition.row += 1;
                return false;
            }

            //left
            if (isInBoard(playerPosition.row, playerPosition.col - 1, playGround)
                    && playGround[playerPosition.row][playerPosition.col - 1] != 'x') {
                playerPosition.col -= 1;
                return false;
            }

            return true;
        }

        return false;
    }

    private static boolean isInBoard(int row, int col, char[][] playGround) {
        return row >= 0 && col >= 0
                && row < playGround.length && col < playGround[row].length;
    }


    private static int calculateDamage(String spell) {
        switch (spell) {
            case "Cloud":
                return 3500;
            case "Eruption":
                return 6000;
            default:
                return 0;
        }
    }

    private static void drawDamageZone(int hitRow, int hitCol, char[][] playGround) {
        for (int i = hitRow - 1; i <= hitRow + 1; i++) {
            for (int j = hitCol - 1; j <= hitCol + 1; j++) {
                if (isInBoard(i,j,playGround))
                playGround[i][j] = 'x';
            }
        }
    }

    private static class Position {
        int row = 0;
        int col = 0;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return String.format("%s, %s", row, col);
        }
    }
}
