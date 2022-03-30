import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Neil Alishev
 */

public class Test extends Util {
    public static void main(String[] args) {
        GameField gameField1 = new GameField("Player 1");
        GameField gameField2 = new GameField("Player 2");
        int[][] c1={{1, 1, 1, 1, -1, -1, -1, 1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, 1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, 1, 1, -1, -1, -1}, {-1, 1, 1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {1, 1, -1, -1, 1, -1, -1, 1, 1, 1}};
        int[][] c2={{1, 1, 1, 1, -1, -1, -1, 1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, 1, -1, -1, -1, -1, -1, -1, 1}, {-1, -1, -1, -1, -1, 1, 1, -1, -1, -1}, {-1, 1, 1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {1, 1, -1, -1, 1, -1, -1, 1, 1, 1}};

        gameField1.setPlayerField(c1);
        gameField2.setPlayerField(c2);


       int[][]b= gameField1.getPlayerField();
        System.out.println(b[0][1]);
//        System.out.println(Arrays.deepToString(gameField1.getPlayerField()));
        Battleship battleship = new Battleship(gameField1, gameField2);
//      int[][] shipCoordinates={{1,4},{1,5},{1,6},{1,7}};
//        System.out.println(gameField1.getShipAureole(shipCoordinates,4));
        // Какое-нибудь валидное игровое поле:

        // 4 - 0,0;0,1;0,2;0,3
        // 3(1) - 1,6;1,7;1,8
        // 3(2) - 3,2;4,2;5,2
        // 2(1) - 4,4;4,5
        // 2(2) - 7,2;7,3
        // 2(3) - 9,8;9,9
        // 1(1) - 2,0
        // 1(2) - 9,0
        // 1(3) - 7,6
        // 1(4) - 4,8

//        gameField1.arrangePlayerField();
//        gameField1.printField();
//
//        GameField gameField2 = new GameField("Player2");
//        gameField2.arrangePlayerField();
//        gameField2.printField();
//
//        Battleship battleship = new Battleship(gameField1, gameField2);
//        battleship.play();
//        Scanner scanner= new Scanner(System.in);
//        System.out.println("enter coordinate");
//
//        String userName =  scanner.nextLine();  // Read user input
//        System.out.println(Arrays.deepToString(parseShipCoordinates(userName, 4)));
//        System.out.println(checkCoordinates(userName, 8));
//        System.out.println(checkShip(parseShipCoordinates(userName, 4),4));
//        System.out.println("Расположен вертикально? "+verticalOrHorizontal(parseShipCoordinates(userName, 4)));

    }
}
