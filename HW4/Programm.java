package HW4;

import java.util.LinkedList;
import java.util.Queue;

public class Programm {
    public static void main(String[] args) {
        int[] startP = new int[]{3,1};
        Queue<int[]> pathCalc = new LinkedList<int[]>();
        pathCalc.add(startP);
        int[][] intMap = new int[][]{{0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0},
                                     {0, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1 , 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    };
        HW4.printMap(intMap);
    }
}
