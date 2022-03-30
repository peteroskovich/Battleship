import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Neil Alishev
 */
public class Battleship {
    // поле первого игрока
    private GameField player1Field;
    // поле второго игрока
    private GameField player2Field;

    // true, пока игра идет. false, когда игра заканчивается
    private boolean gameIsOn(int check[][]) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (check[i][j] == 1)
                    return true;
            }
        }

        return false;
        //написать условия заканчивания боя
    }



    // кто сейчас ходит (true - player1, false - player2)
    public boolean isPlayer1;
    // логика продолжения хода Player1


    // количество кораблей на плаву игрока 1
    private int player1ShipCount;

    {
        // геттер кораблей ( или координат?)
    }

    // количество кораблей на плаву игрока 2
    private int player2ShipCount;

    {
        // геттер кораблей ( или координат?)
    }

    private static int[] parseCoordinare(String str) {
        int[] arr = Arrays.stream(str.substring(0, str.length()).split(","))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
        return arr;
    }
    private void gameMove(Scanner scannedCoordinate){
        System.out.println("Введите координаты для удара x,y");
        Scanner scanner1 = new Scanner(System.in);
    }
    public void printField(int[][] playerField) {
        for (int[] x : playerField) {
            for (int y : x) {
                if (y == -1)
                    System.out.print("⬜" + " ");
                if (y == 1)
                    System.out.print("⬜" + " ");
                if (y == -2)
                    System.out.print("X" + " ");
            }
            System.out.println();
        }
    }

    // единственный конструктор
    // внутри проверяется, что оба поля заполнены
    // также, инициализируются значения всех полей
    public Battleship(GameField player1Field, GameField player2Field) {

        //set player1field нужно сделать

        // TODO

        System.out.println("Играет игрок 1:");
        System.out.println("Введите координаты для удара x,y");
        Scanner scanner1 = new Scanner(System.in);
        String scannerShip = scanner1.nextLine();
        int[][] fild1 = player1Field.getPlayerField();
        int[][] fild2 = player2Field.getPlayerField();
//boolean isPlayer=isPlayer1;
//isPlayer=true;

        while (gameIsOn(player1Field.getPlayerField()) && gameIsOn(player2Field.getPlayerField())) {
//            hit(fild1, parseCoordinare(scannerShip));
//            printField(fild1);
            while (makeMove(scannerShip)) {
                System.out.println("Первый филд");
                printField(fild1);
                System.out.println("Второй филд");
                printField(fild2);

                if (!isPlayer1) {

                    System.out.println("Играет игрок 2");
                    hit(fild2, parseCoordinare(scannerShip));
                    printField(fild2);
                } else {
                    System.out.println("Играет игрок 1:");
                    hit(fild1, parseCoordinare(scannerShip));
                    printField(fild1);
                }


                System.out.println("Введите координаты для удара x,y");
                scannerShip = scanner1.nextLine();
            }
            }
        if (!gameIsOn(player1Field.getPlayerField())) {
            System.out.println("Игрок 2 выйграл");
        } else {
            System.out.println("Игрок 1 выйграл");
        }


        // вставить законченый поля , проверить по логике кол во заполненых кораблей
    }

    // запускает цикл игры пока gameIsOn = true
    public void play() {
        // возможно создание констркуктора
        // TODO
    }
//boolean isPlayer1,

    // возвращает true, если userInput - валидный ход. Возвращает false, если userInput - невалидный ход
    // первый аргумент true если это ход первого игрока, false - если это ход второго игрока
    private boolean makeMove(String userInput) {
        // на true давать ходить первого игрока на false второму
        //проверка userInput на логику хода
        if (!checkCoordinates(userInput))
            return false;
        String[] stringCoordinate = userInput.split("[,;]+");

        int[] hitCoordinate = new int[stringCoordinate.length];
        for (int i = 0; i < stringCoordinate.length; i++) {
            hitCoordinate[i] = Integer.parseInt(stringCoordinate[i]);
        }
        for (int i : hitCoordinate) {
            if (i > 9 || i < 0)
                return false;
        }
        return true;
    }

    public static boolean checkCoordinates(String userInput) {

        int correctNumberOfCoordinates;
        correctNumberOfCoordinates = 2;
        String[] string = userInput.split("[,;]+");
        return string.length == correctNumberOfCoordinates;
    }

    // Производит удар по ячейке
    // Выводит сообщение либо "Мимо!", либо "Попадание", либо "Утопил".
    // В случае потопления декременитирует количество кораблей на плаву
    // Переводит право на ход другому игроку, если удар был "Мимо!"
    private void hit(int[][] playerField, int[] hitCoordinate) {
        // TODO
        if (playerField[hitCoordinate[0]][hitCoordinate[1]] == -1 || playerField[hitCoordinate[0]][hitCoordinate[1]] == 0) {
            if(!isPlayer1) {
                isPlayer1 = true;
            }
            else
                isPlayer1=false;
            System.out.println("Мимо");



        }
        if (playerField[hitCoordinate[0]][hitCoordinate[1]] == 1) {
            System.out.println("Попал");
            isPlayer1 = true;
         //   hit(playerField, hitCoordinate);
        }
// При вводе координат создавать Map c ключём размера коробля, и в значении передовать какую то связь с опеределлыми
        // координатами int[]




        // писать когда выйграл


        if (playerField[hitCoordinate[0]][hitCoordinate[1]] == 1 && !shipSank(playerField, hitCoordinate)) {
            System.out.println("Потопил");
           // hit(playerField, hitCoordinate);
        }
        //удаляет координату, возможно null заменяем
        // при Мимо player1 =false;
    }

    // true - если удар утопил корабль
    // false - если удар не утопил корабль
    private boolean shipSank(int[][] playerField, int[] hitCoordinate) {
        // идем вверх - вниз и вправо-влево пока не упремся в ареол  ?????.
        playerField[hitCoordinate[0]][hitCoordinate[1]] = -2;
        int dx, dy;
        int x = hitCoordinate[0];
        int y = hitCoordinate[1];
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                dx = x + i;
                dy = y + j;
                if ((dx >= 0) & (dx < 10) & (dy >= 0) & (dy < 10) && (playerField[dx][dy] == 1)) {
                    count++;

                }
            }
        }

        return count >= 1;

    }
}
