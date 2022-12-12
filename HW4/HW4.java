package HW4;

import java.util.LinkedList;
import java.util.Queue;

public class HW4 {

    public static int[] getToEndPoint(int[][] mapa, int[] start) {
        int[] finish = new int[] { -1, -1 };
        System.out.println(mapa.length);
        System.out.println(mapa[0].length);
        // System.out.printf("x %d, y %d\n", start[0], start[1]); // print start
        Queue<int[]> pathCalc = new LinkedList<int[]>();
        pathCalc.add(start);
        mapa[start[1]][start[0]] = 1;
        printMap(mapa);
        int[] tempc = new int[] { 0, 0 };
        while (pathCalc.size() != 0) {
            int[] point = pathCalc.poll();
            int x = point[1];
            int y = point[0];
            System.out.printf("x %d, y %d\n", point[0], point[1]);

            // if (x < 0 || y < 0)
            // System.err.println("x or y < 0. Error!");

            if (mapa[y][x + 1] == 0) {
                mapa[y][x + 1] = mapa[y][x] + 1;
                pathCalc.add(new int[] { y, x + 1 });
            }
            if (mapa[y][x - 1] == 0) {
                mapa[y][x - 1] = mapa[y][x] + 1;
                pathCalc.add(new int[] { y, x - 1 });
            }
            if (mapa[y + 1][x] == 0) {
                mapa[y + 1][x] = mapa[y][x] + 1;
                pathCalc.add(new int[] { y + 1, x });
            }
            if (mapa[y - 1][x] == 0) {
                mapa[y - 1][x] = mapa[y][x] + 1;
                pathCalc.add(new int[] { y - 1, x });
            }
            printMap(mapa);
        }
        return finish;
    }

    public static void printMap(int[][] mapa) {
        // String wall = "▒▒"; // "█▓▒░"
        for (int[] is : mapa) {
            for (int i = 0; i < is.length; i++) {
                if (is[i] == -1)
                    System.out.print("▓▓");
                else if (is[i] == -2)
                    System.out.print("▒▒");
                else
                    System.out.printf("%2d", is[i]);
            }
            System.out.printf("\n");
        }
    }
}
