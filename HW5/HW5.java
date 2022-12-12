package HW5;

public class HW5 {
    public static int triAngularNumber(int num) {
        int resn = 0;
        if (num <= 0)
            return 0;
        else {
            for (int i = 1; i <= num; i++) {
                resn += i;
            }
        }
        return resn;
    }

    public static int nAngularNumber(int base, int num) {
        if (base < 2)
            return -1;
        int resn = 0;
        int k = base - 2;
        if (num <= 0)
            return 0;
        else {
            int count = 1;
            for (int i = 1; i <= num; i++) {
                resn += count;
                count += k;
            }
        }
        return resn;
    }

    public static void printTriAngularNumbers(int num) {
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= i; j++) {
                    if (i == j) {
                        System.out.printf("%d", j);
                    } else {
                        System.out.printf("%d + ", j);
                    }
                }
                System.out.printf("\n");
            }
            System.out.println(triAngularNumber(num));
        }
        // System.out.printf("]\n");
    }

    public static void printNAngularNumbers(int base, int num) {
        if (base > 2){
            if (num > 0) {
                int k = base - 2;
                for (int i = 1; i <= num; i++) {
                    int count = 1;
                    for (int j = 1; j <= i; j++) {
                        if (i == j) {
                            System.out.printf("%d", count);
                        } else {
                            System.out.printf("%d + ", count);
                        }
                        count += k;
                    }
                    System.out.printf("\n");
                }
                System.out.println(nAngularNumber(base, num));
            }
        }
        // System.out.printf("]\n");
    }

}
