/*
Написать программу вычисления n-ого треугольного числа.
1  2  3   4   5   6   7   8   9  10  11  12  13   14   15
1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120 
*/
package HW5;

public class Programm {
    public static void main(String[] args) {
        int n = 10;
        // HW5.triAngularNumber(n);
        int tnum = HW5.nAngularNumber(3, n);
        System.out.println(tnum);
        HW5.printTriAngularNumbers(n);
        // Quadratic numbers
        // 1  2  3   4   5   6   7   8   9   10   11   12   13   14   15   16   17   18   19   20
        // 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400
        int qnum = HW5.nAngularNumber(4, n);
        System.out.println(qnum);
        // Pentatic?  numbers
        // 1  2   3   4   5   6   7   8    9   10   11   12   13   14   15   16   17   18   19   20
        // 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, 176, 210, 247, 287, 330, 376, 425, 477, 532, 590
        int pnum = HW5.nAngularNumber(5, n);
        System.out.println(pnum);
        // 12-tic  numbers
        // 1   2   3   4    5    6    7    8    9   10   11   12   13   14    15    16    17    18    19    20
        // 1, 12, 33, 64, 105, 156, 217, 288, 369, 460, 561, 672, 793, 924, 1065, 1216, 1377, 1548, 1729, 1920
        int twnum = HW5.nAngularNumber(12, n);
        System.out.println(twnum);
        HW5.printNAngularNumbers(12, n);
    }
}
