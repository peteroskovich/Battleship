import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * @author Neil Alishev
 * <p>
 * Collection of useful static methods
 */
// Класс с полезными статическими методами
public class Util {
    // Парсит одну координату (x,y)
    public static int[] parseCoordinate(String inputCoordinate) {
        int[] in=new int[2];
        String[] string = inputCoordinate.split(",");

// Create array of float for each pair of coordinate

        for (int i = 0; i <=1; i++)
        {
            in[i] = parseInt(string[i]);
        }
        // TODO
        return in;
    }

    // Парсит координаты корабля (x1,y1;xn,yn)
    public static int[][] parseShipCoordinates(String shipCoordinates, int shipSize) {
        int[][] inn=new int[shipSize][2];
        String[] string = shipCoordinates.split("[,;]+");
        if(string.length<shipSize*2) {
            int n = 0;
            for (int i = 0; i < string.length; i++)
                for (int y = 0; y < string.length / 2; y++) {
                    inn[i][y] = parseInt(string[n]);
                    n++;
                }
        }

// Create array of float for each pair of coordinate
        else {
            int n = 0;
            for (int i = 0; i < shipSize; i++)
                for (int y = 0; y < 2; y++) {
                    inn[i][y] = parseInt(string[n]);
                    n++;
                }
        }
        return inn;
    }

    // Проверяет координату x,y на валидность

    //!!!
    public static boolean checkCoordinate(String inputCoordinate) {
        // TODO
        return false;
    }

    // проверяет координаты корабля на валидность
    // (проверяет, что количество координат соответствует размеру корабля и проверяет отдельно каждую
    // координату x,y на валидность)


//        if (parseShipCoordinates(userInput, correctNumberOfCoordinates / 2).length <= correctNumberOfCoordinates / 2 || parseShipCoordinates(userInput, correctNumberOfCoordinates / 2)[0].length <= 2)
//        {
//            for (int i = 0; i < (parseShipCoordinates(userInput, correctNumberOfCoordinates / 2).length)/2; i++)
//                for (int y = 0; y < 2; y++)
//                    if(0<=parseShipCoordinates(userInput, correctNumberOfCoordinates / 2)[i][y] && parseShipCoordinates(userInput, correctNumberOfCoordinates / 2)[i][y] <=10) {
//                        return true;
//                    }
//    }

  //  }
// Вродебы больше не использую

    // Проверяет, что координаты - это валидный корабль
    // для корректного корабля одна координата всегда должна быть одинаковой
    // а вторая координата должна увеличиваться на единицу
    public static boolean checkShip(int[][] shipCoordinates, int shipSize) {
        if( shipCoordinates.length < shipSize) {
            int x;
            x =  (shipSize*2)-shipCoordinates.length;
            System.out.println("Недостаточно координат введите еще "+ x +" координаты");
            return false;
        }

        for (int[] shipCoordinate : shipCoordinates) {
            for (int i : shipCoordinate) {
                if (i > 9 || i < 0)
                    return false;
            }
        }

  //          Read more:https:
//javarevisited.blogspot.com/2015/09/how-to-loop-two-dimensional-array-in-java.html#ixzz7KxrGaxAr
            switch (shipSize) {
                case 4 -> {
                    //если x одинаковы прибавляем по y
                    if (shipCoordinates[0][0] == shipCoordinates[1][0] && shipCoordinates[0][1] + 1 == shipCoordinates[1][1] && shipCoordinates[1][1] + 1 == shipCoordinates[2][1] && shipCoordinates[2][1] + 1 == shipCoordinates[3][1])
                        return true;
                        //если y одинаковы
                    else
                        return shipCoordinates[0][1] == shipCoordinates[1][1] && shipCoordinates[0][0] + 1 == shipCoordinates[1][0] && shipCoordinates[1][0] + 1 == shipCoordinates[2][0] && shipCoordinates[2][0] + 1 == shipCoordinates[3][0];
                }
                case 3 -> {
                    if (shipCoordinates[0][0] == shipCoordinates[1][0] && shipCoordinates[0][1] + 1 == shipCoordinates[1][1] && shipCoordinates[1][1] + 1 == shipCoordinates[2][1])
                        return true;
                        //если y одинаковы
                    else
                        return shipCoordinates[0][1] == shipCoordinates[1][1] && shipCoordinates[0][0] + 1 == shipCoordinates[1][0] && shipCoordinates[1][0] + 1 == shipCoordinates[2][0];
                }
                case 2 -> {
                    if (shipCoordinates[0][0] == shipCoordinates[1][0] && shipCoordinates[0][1] + 1 == shipCoordinates[1][1])
                        return true;
                        //если y одинаковы
                    else
                        return shipCoordinates[0][1] == shipCoordinates[1][1] && shipCoordinates[0][0] + 1 == shipCoordinates[1][0];
                }
                case 1 -> {
                    return true;

                }
            }
            // проверка на одну координату константу
            // TODO
            // проверка на одну возрастающую на единицу координату
            // TODO
            return false;

        }

    // Проверяет, что в массиве все значения одинаковые (используется в методе checkShip)
    private static boolean allValuesEqual(int[] array) {
        // TODO
        return false;
    }

    // Проверяет, что в массиве значения увеличиваются на единицу (используется в методе checkShip)
    private static boolean allValuesAscending(int[] array) {
        // TODO
        return false;
    }

    // возвращает true, если корабль расположен вертикально и false, если горизонтально
    public static boolean verticalOrHorizontal(int[][] shipCoordinates) {
        return shipCoordinates[0][0] == shipCoordinates[1][0] || shipCoordinates[0][1] + 1 == shipCoordinates[1][1];
    }

}
