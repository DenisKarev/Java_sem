package HW4;

public class Point2d implements Comparable<Point2d> {
    int x;
    int y;

    public Point2d(int a, int b) {
        this.x = a;
        this.y = b;
    }

    @Override
    public int compareTo(Point2d po) {
        if (this.x == po.x && this.y == po.y)
            return 0;
        else
            return -1;
    }

}