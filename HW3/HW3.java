package HW3;

public class HW3 {
    public static long calcRec(int a, int b, int mul, int add) {
        /** Тупо рекурсия */
        if (a > b)
            return 0;
        if (a == b) {
            return 1;
        }
        if (b % mul == 0) {
            return calcRec(a, b - add, mul, add) + calcRec(a, b / mul, mul, add);
        }
        return calcRec(a, b - add, mul, add);
    }

    public static long calcTableLong(int a, int b, int mul, int add) {
        /**
         * Считает по формулам (уравнениям) для результатов более чем лезет в Integer
         */
        /**
         * как в примере
         * https://code-enjoy.ru/ege_po_informatike_2023_zadanie_23_chudo_shablon/
         * Способ 3
         */
        long result = 0;
        long[][] cTable = new long[4][a + b];
        for (int i = 0; i < cTable[0].length; i++) {
            cTable[0][i] = i;
        }
        for (int i = add + 1; i < cTable[1].length; i++) {
            cTable[1][i] = i - add;
        }
        for (int i = mul; i < cTable[2].length; i += mul) {
            if (i >= a)
                cTable[2][i] = i / mul;
        }
        cTable[3][a] = 1;
        for (int i = a; i < cTable[3].length; i++) {
            if (cTable[1][i] >= a) {
                cTable[3][i] += cTable[3][(int) cTable[1][i]];
            }
            if (cTable[2][i] >= a) {
                cTable[3][i] += cTable[3][(int) cTable[2][i]];
            }

        }
        result = cTable[3][b];
        return result;
    }

    public static long calcTableInt(int a, int b, int mul, int add) {
        /** Считает по формулам (уравнениям) для результатов которые влазят Integer */
        /**
         * как в примере
         * https://code-enjoy.ru/ege_po_informatike_2023_zadanie_23_chudo_shablon/
         * Способ 3
         */
        long result = 0;
        int[][] cTable = new int[4][b + 1];
        for (int i = 0; i < cTable[0].length; i++) {
            cTable[0][i] = i;
        }
        for (int i = add + 1; i < cTable[1].length; i++) {
            cTable[1][i] = i - add;
        }
        for (int i = mul; i < cTable[2].length; i += mul) {
            if (i >= a)
                cTable[2][i] = i / mul;
        }
        cTable[3][a] = 1;
        for (int i = a; i < cTable[3].length; i++) {
            if (cTable[1][i] >= a) {
                cTable[3][i] += cTable[3][(int) cTable[1][i]];
            }
            if (cTable[2][i] >= a) {
                cTable[3][i] += cTable[3][(int) cTable[2][i]];
            }

        }
        // printArrayInts(cTable[0]);
        // printArrayInts(cTable[1]);
        // printArrayInts(cTable[2]);
        // printArrayInts(cTable[3]);

        result = cTable[3][b];
        return result;
    }

    public static long calcInts(int a, int b, int mul, int add) {
        /** Считает по формулам (уравнениям) */
        long result = 0;

        long[] cMoves = new long[b + 1];
        cMoves[a] = 1;
        int idx = 0;
        while (idx <= b) {
            if (idx % mul == 0 && idx / mul > 0) {
                cMoves[idx] += cMoves[idx / mul];
            }
            if (idx > a && idx - add > 0) {
                cMoves[idx] += cMoves[idx - add];
            }
            idx++;
        }
        // printArrayInts(cMoves);
        result = cMoves[b];
        return result;
    }

    public static void printOnePath(int a, int b, int mul, int add) {
        /** Считает по формулам (уравнениям) */
        long[] cMoves = new long[b + 1];
        cMoves[a] = 1;
        int idx = 0;
        int curri = a % mul == 0 ? a : a + add;
        if (calcInts(a, b, mul, add) != 0) {        // проверка на решаемость
            System.out.printf("a = %d, цель b = %d, множ = %d, плюс = %d\n", a, b, mul, add);
            while (idx <= b) {
                if (idx % mul == 0 && idx / mul > 0) {
                    cMoves[idx] += cMoves[idx / mul];
                    if (idx * mul <= b && curri == idx) {
                        if (curri == b / mul) {
                            System.out.printf("%d *%d = %d", idx, mul, (idx * mul));
                        } else {
                            System.out.printf("%d *%d = %d  -->  ", idx, mul, (idx * mul));
                        }
                        curri = idx * mul;
                        // System.out.printf("m %d\n", curri);
                    }
                }
                if (idx > a && idx - add > 0) {
                    cMoves[idx] += cMoves[idx - add];
                    if (idx + add <= b && curri == idx) {
                        if (curri == b - add) {
                            System.out.printf("%d +%d = %d \n", idx, add, (idx + add));
                        } else {
                            System.out.printf("%d +%d = %d  -->  ", idx, add, (idx + add));
                        }
                        curri = idx + add;
                        // System.out.printf("a %d\n", curri);
                    }
                }
                idx++;
            }
        } else
            System.out.println("Решений же нет, какой путь?");
    }

    public static void printArrayInts(int[] array) {
        System.out.printf("[ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%2d, ", array[i]);
        }
        System.out.printf("%2d ", array[array.length - 1]);
        System.out.printf("]\n");
    }
}
