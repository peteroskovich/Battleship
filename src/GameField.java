import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Neil Alishev
 */
public class GameField extends Util {
    private String playerName;

// возможно каждому кораблю присваивать свой номер

    // корабль: 1
    // ареол корабля: 0
    // пустое пространство: -1
    // атакованная клетка: -2
    private int[][] playerField;

// логичто заменяем значениями [][]координат x,y наверное значения координат

    // выставляется true тогда, когда до конца отрабатывает метод arrangePlayerField()

    // !!!!

    private boolean playerFieldArranged;
    // возможно изначальный lenght[][] равен расставленному?

    // инициализируется поле с пустым пространством (-1)
    private void arrangeShip(int shipSize, Scanner scannedCoordinate) {

        System.out.println("Enter coordinate in format (x,y;x,y;...) of " + shipSize + " size ship - ");
        String scannerShip = scannedCoordinate.nextLine();

        //     checkArrangeShip(scannerShip, scannedCoordinate, shipSize);
        checkerShip(scannerShip, scannedCoordinate, shipSize);
        arrangePlayerField(playerField, parseShipCoordinates(checkArrangeShip(scannerShip, scannedCoordinate, shipSize), shipSize));
        printField();
    }


    public GameField(String playerName) {
        playerField = new int[10][10];
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                playerField[i][j] = -1;
//        Scanner scanner1 = new Scanner(System.in);
//        printFirstField();
//        int shipSize;
//        shipSize = 4;
//        arrangeShip(shipSize, scanner1);
//        shipSize = 3;
//        arrangeShip(shipSize, scanner1);
//        arrangeShip(shipSize, scanner1);
//        shipSize = 2;
//        arrangeShip(shipSize, scanner1);
//        arrangeShip(shipSize, scanner1);
//        arrangeShip(shipSize, scanner1);
//        shipSize = 1;
//        arrangeShip(shipSize, scanner1);
//        arrangeShip(shipSize, scanner1);
//        arrangeShip(shipSize, scanner1);
//        arrangeShip(shipSize, scanner1);


        //создает playerField заполняет -1
    }

    public String getPlayerName() {
        return playerName;
    }

    public int[][] getPlayerField() {
        return playerField;
    }
    public void setPlayerField(int[][] c) {
        this.playerField = c;
    }

    public boolean isPlayerFieldArranged() {
        return playerFieldArranged;
    }

    // Расставляет все корабли для этого поля
    public void arrangePlayerField(int[][] playerField, int[][] inn) {
        int x;
        int y;
        int j = 0;

        for (int i = 0; i < inn.length; i++) {
            x = inn[i][j];
            y = inn[i][j + 1];
            playerField[x][y] = 1;
            // TODO
            //сначало arrangeShip проверка а потом уже расставляет если проходит все тесты

            // наверное просит координаты  и заменяет значения с координатами кораблей
        }
    }

    // Выводит поле на экран

    public void printFirstField() {
        System.out.println("The format of the field is ");
        System.out.println("  0 1 2 3 4 5 6 7 8 9 ");
        System.out.println("0 - - - - - - - - - - ");
        System.out.println("1 - - - - - - - - - - ");
        System.out.println("2 - - - - - - - - - - ");
        System.out.println("3 - - - - - - - - - - ");
        System.out.println("4 - - - - - - - - - - ");
        System.out.println("5 - - - - - - - - - - ");
        System.out.println("6 - - - - - - - - - - ");
        System.out.println("7 - - - - - - - - - - ");
        System.out.println("8 - - - - - - - - - - ");
        System.out.println("9 - - - - - - - - - - ");
    }

    public void printField() {
        for (int[] x : playerField) {
            for (int y : x) {
                if (y == -1)
                    System.out.print("⬜" + " ");
                if (y == 1)
                    System.out.print("\uD83D\uDEE5" + " ");
            }
            System.out.println();
        }
    }

    private void checkerShip(String shipScanString, Scanner sc, int shipSize) {

        while (!checkShip(parseShipCoordinates(shipScanString, shipSize), shipSize)) {
            System.out.println("Неправильный координаты корабыля");
            System.out.println("Repeat coordinate of " + shipSize + " size ship - ");
            shipScanString = sc.nextLine();
        }


    }

    private String checkArrangeShip(String shipScanString, Scanner sc, int shipSize) {
        while (!checkAround(parseShipCoordinates(shipScanString, shipSize), playerField)) {
            System.out.println("Входит в ореол корабля");
            System.out.println("Repeat coordinate of " + shipSize + " - ");
            shipScanString = sc.nextLine();

        }


        return shipScanString;
    }

    // Пытается поставить на поле новый корабль, принимая на вход ввод из консоли
    // Вовзращает true, если корабль удалось поставить и false, если не удалось (не прошли все проверки, описанные в задании)
    private boolean arrangeShip(String userInput, int shipSize) {

        // TODO


        return false;
    }

    //
//    // этот метод вызывается в методе arrangeShip(String userInput, int shipSize) после того,
//    // как прошли проверки на все возможные условия
//    // этот метод непосредственно наносит на поле сам корабль и его ореол
//    // (меняет значения в двумерном массиве)
//    // 1 - сам корабль. 0 - ореол этого корабля
    private void arrangeShip(int[][] shipCoordinates, int shipSize) {
        // TODO
    }

    //
//    // проверяет, что валидный корабль можно поставить на поле
//    // проверяет, что:
//    // 1) Сам корабль занимает свободное пространство на поле
//    // 2) В ореоле этого корабля нет кораблей
    private boolean arrangementPossible(int[][] shipCoordinates, int shipSize) {
        // проверяем пространство для самого корабля
        // TODO

        // проверяем простанство ареола корабля
        // TODO

        return false;
    }

    public boolean checkAround1(int x, int y, int[][] playerField) {

        int dx, dy;

        if ((x >= 0) & (x < 10) & (y >= 0) & (y < 10) && ((playerField[x][y] == -1) || (playerField[x][y] == 2))) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    dx = x + i;
                    dy = y + j;
                    if ((dx >= 0) & (dx < 10) & (dy >= 0) & (dy < 10) && (playerField[dx][dy] == 1)) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAround(int[][] inn, int[][] playerField) {
        int x;
        int y;
        boolean check = true;
        int dx, dy;

        for (int I = 0; I < inn.length && check; I++) {

            int Y = 0;
            x = inn[I][Y];
            y = inn[I][Y + 1];

            if (!checkAround1(x, y, playerField)) {
                check = false;
            }
        }
        return check;
    }


    //уже не нужно
//    // Возвращает координаты ореола корабля
    public List<Integer> getShipAureole(int[][] shipCoordinates, int shipSize) {
        // TODO
        List<Integer> ShipAureole = new ArrayList<Integer>();
        if (Util.verticalOrHorizontal(shipCoordinates)) {
            switch (shipSize) {
                case 4: {
                    ShipAureole.add(shipCoordinates[0][0] - 1);
                    ShipAureole.add(shipCoordinates[0][1]);
                    ShipAureole.add(shipCoordinates[0][0] + 1);
                    ShipAureole.add(shipCoordinates[0][0]);
                    ShipAureole.add(shipCoordinates[0][1] + 1);

                    ShipAureole.add(shipCoordinates[1][1]);
                    ShipAureole.add(shipCoordinates[1][0] - 1);
                    ShipAureole.add(shipCoordinates[1][1]);
                    ShipAureole.add(shipCoordinates[1][0] + 1);

                    ShipAureole.add(shipCoordinates[2][1]);
                    ShipAureole.add(shipCoordinates[2][0] - 1);
                    ShipAureole.add(shipCoordinates[2][1]);
                    ShipAureole.add(shipCoordinates[2][0] + 1);

                    ShipAureole.add(shipCoordinates[3][0] - 1);
                    ShipAureole.add(shipCoordinates[3][1]);
                    ShipAureole.add(shipCoordinates[3][0] + 1);
                    ShipAureole.add(shipCoordinates[3][0]);
                    ShipAureole.add(shipCoordinates[3][1] - 1);
                }

                case 3: {
                    ShipAureole.add(shipCoordinates[0][0] - 1);
                    ShipAureole.add(shipCoordinates[0][1]);
                    ShipAureole.add(shipCoordinates[0][0] + 1);
                    ShipAureole.add(shipCoordinates[0][1]);
                    ShipAureole.add(shipCoordinates[0][0]);
                    ShipAureole.add(shipCoordinates[0][1] + 1);

                    ShipAureole.add(shipCoordinates[1][1]);
                    ShipAureole.add(shipCoordinates[1][0] - 1);
                    ShipAureole.add(shipCoordinates[1][1]);
                    ShipAureole.add(shipCoordinates[1][0] + 1);

                    ShipAureole.add(shipCoordinates[2][0] - 1);
                    ShipAureole.add(shipCoordinates[2][1]);
                    ShipAureole.add(shipCoordinates[2][0] + 1);
                    ShipAureole.add(shipCoordinates[2][1]);
                    ShipAureole.add(shipCoordinates[2][0]);
                    ShipAureole.add(shipCoordinates[2][1] - 1);
                }

                case 2: {
                    ShipAureole.add(shipCoordinates[0][0] - 1);
                    ShipAureole.add(shipCoordinates[0][1]);
                    ShipAureole.add(shipCoordinates[0][0] + 1);
                    ShipAureole.add(shipCoordinates[0][1]);
                    ShipAureole.add(shipCoordinates[0][0]);
                    ShipAureole.add(shipCoordinates[0][1] + 1);


                    ShipAureole.add(shipCoordinates[1][0] - 1);
                    ShipAureole.add(shipCoordinates[1][1]);
                    ShipAureole.add(shipCoordinates[1][0] + 1);
                    ShipAureole.add(shipCoordinates[1][1]);
                    ShipAureole.add(shipCoordinates[1][0]);
                    ShipAureole.add(shipCoordinates[1][1] - 1);
                }

                case 1: {
                    ShipAureole.add(shipCoordinates[0][0] - 1);
                    ShipAureole.add(shipCoordinates[0][1]);
                    ShipAureole.add(shipCoordinates[0][0] + 1);
                    ShipAureole.add(shipCoordinates[0][1] - 1);
                    ShipAureole.add(shipCoordinates[0][0]);
                    ShipAureole.add(shipCoordinates[0][1] + 1);
                }

            }
        }

        return ShipAureole;
    }
}
