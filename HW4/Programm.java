package HW4;

import java.util.LinkedList;

public class Programm {

    public static void main(String[] args) {
        int[][] intMap =   {{-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
                            {-2,  -5,  0, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0, -2},
                            {-2,  0,  0, -1, -5,  0,  0,  0,  0,  0,  0, -5,  0, -2},
                            {-2,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -2},
                            {-2,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1,  0,  0, -2},
                            {-2,  0, -1, -1, -1, -1,  0,  0,  0,  0,  0,  0,  0, -2},
                            {-2,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1, -1,  0, -2},
                            {-2,  0,  0,  0,  1,  0,  0,  0,  0,  0, -1, -1,  -5, -2},  // startP
                            {-2,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -2},
                            {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
                        };                // startP

        Point2d startP = new Point2d(7,4);
        LinkedList<Point2d> endPs = new LinkedList<Point2d>();
        HW4.printMap(intMap, 1);

        endPs = HW4.getToEndPoint(intMap, startP);
        // HW4.printMap(intMap, 0);

        HW4.printThePathes(intMap, endPs);

    }
}
