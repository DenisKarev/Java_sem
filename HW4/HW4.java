package HW4;

import java.util.LinkedList;
import java.util.Queue;

public class HW4 {

    public static LinkedList<Point2d> getToEndPoint(int[][] map, Point2d start) {
        LinkedList<Point2d> finishes = new LinkedList<Point2d>();
        Queue<Point2d> mapQueue = new LinkedList<Point2d>();
        mapQueue.add(start);
        map[start.x][start.y] = 1;

        while (mapQueue.size() != 0) {
            Point2d ps = mapQueue.poll();

            switch (map[ps.x][ps.y + 1]) {
                case 0:
                    map[ps.x][ps.y + 1] = map[ps.x][ps.y] + 1;
                    mapQueue.add(new Point2d(ps.x, ps.y + 1));
                    break;
                case -5:
                    Point2d pt = new Point2d(ps.x, ps.y + 1);
                    if (!checkFinishes(finishes, pt)) {
                        finishes.add(pt);
                        map[ps.x][ps.y + 1] = map[ps.x][ps.y] + 1;
                    }
                    break;
                default:
                    break;
            }

            switch (map[ps.x][ps.y - 1]) {
                case 0:
                    map[ps.x][ps.y - 1] = map[ps.x][ps.y] + 1;
                    mapQueue.add(new Point2d(ps.x, ps.y - 1));
                    break;
                case -5:
                    Point2d pt = new Point2d(ps.x, ps.y - 1);
                    if (!checkFinishes(finishes, pt)) {
                        map[ps.x][ps.y - 1] = map[ps.x][ps.y] + 1;
                        finishes.add(pt);
                    }
                    break;
                default:
                    break;
            }

            switch (map[ps.x + 1][ps.y]) {
                case 0:
                    map[ps.x + 1][ps.y] = map[ps.x][ps.y] + 1;
                    mapQueue.add(new Point2d(ps.x + 1, ps.y));
                    break;
                case -5:
                    Point2d pt = new Point2d(ps.x + 1, ps.y);
                    if (!checkFinishes(finishes, pt)) {
                        finishes.add(pt);
                        map[ps.x + 1][ps.y] = map[ps.x][ps.y] + 1;
                    }
                    break;
                default:
                    break;
            }

            switch (map[ps.x - 1][ps.y]) {
                case 0:
                    map[ps.x - 1][ps.y] = map[ps.x][ps.y] + 1;
                    mapQueue.add(new Point2d(ps.x - 1, ps.y));
                    break;
                case -5:
                    Point2d pt = new Point2d(ps.x - 1, ps.y);
                    if (!checkFinishes(finishes, pt)) {
                        finishes.add(pt);
                        map[ps.x - 1][ps.y] = map[ps.x][ps.y] + 1;
                    }
                    break;
                default:
                    break;
            }

        }
        return finishes;
    }

    public static void printThePathes(int[][] map, LinkedList<Point2d> fins) {
        if (fins.size() > 0) {
            System.out.printf("Найден(о) %d выход(ов) по координатам: ", fins.size());
            for (Point2d val : fins) {
                System.out.printf("(%d, %d) ", val.x, val.y);
            }
            System.out.println();
            for (Point2d val : fins) {
                int[][] temp = copyMap(map);
                temp = drawAPath(temp, val);
                printMap(temp, 1);
            }
        } else {
            System.out.println("Выходов не найдено!");
        }
    }

    private static int[][] drawAPath(int[][] map, Point2d fin) {
        Queue<Point2d> path = new LinkedList<Point2d>();
        int[][] tmap = copyMap(map);
        
        Point2d pw = new Point2d(0, 0);
        path.add(fin);
        while (path.size() != 0) {
            pw = path.poll();
            // System.out.printf("%d - %d %d %d %d\n", tmap[pw.x][pw.y], tmap[pw.x][pw.y + 1], tmap[pw.x][pw.y - 1], tmap[pw.x + 1][pw.y], tmap[pw.x - 1][pw.y]);
            if (tmap[pw.x + 1][pw.y] == tmap[pw.x][pw.y] - 1) {
                map[pw.x + 1][pw.y] = -10;
                path.add(new Point2d(pw.x + 1, pw.y));
            }
            if (tmap[pw.x - 1][pw.y] == tmap[pw.x][pw.y] - 1) {
                map[pw.x - 1][pw.y] = -10;
                path.add(new Point2d(pw.x - 1, pw.y));
            }
            if (tmap[pw.x][pw.y + 1] == tmap[pw.x][pw.y] - 1) {
                map[pw.x][pw.y + 1] = -10;
                path.add(new Point2d(pw.x, pw.y + 1));
            }
            if (tmap[pw.x][pw.y - 1] == tmap[pw.x][pw.y] - 1) {
                map[pw.x][pw.y - 1] = -10;
                path.add(new Point2d(pw.x, pw.y - 1));
            }
        }
        return map;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] res = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                res[i][j] = map[i][j];
            }
        }
        return res;
    }

    private static boolean checkFinishes(LinkedList<Point2d> li, Point2d p) {
        boolean exist = false;
        for (Point2d pinli : li) {
            if (pinli.compareTo(p) == 0) {
                // System.err.printf("%d %d == %d %d", pinli.x, pinli.y, p.x, p.y); // debug
                exist = true;
            }
        }
        return exist;
    }

    public static void printMap(int[][] mapa, int opt) {
        // String wall = "▒▒"; // "█▓▒░"
        for (int[] is : mapa) {
            for (int i = 0; i < is.length; i++) {
                if (is[i] >= 0) {
                    if (is[i] == 1) {
                        System.out.print(" S");
                    } else {
                        if (opt == 1) {
                            System.out.print("  ");
                        } else {
                            System.out.printf("%2d", is[i]);
                        }
                    }
                } else {
                    if (is[i] == -1)
                        System.out.print("▓▓");
                    else if (is[i] == -2)
                        System.out.print("▒▒");
                    else if (is[i] == -5)
                        System.out.print(" F");
                    else if (is[i] == -10)
                        System.out.print(" *");
                    else
                        System.out.print(" _");

                }
            }
            System.out.printf("\n");
        }
    }
}
