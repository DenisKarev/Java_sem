package HW3;

import java.util.Arrays;

public class HW3 {
    public static long calcRec(int a, int b, int mul, int add, long[] counter) {
        // int number = 0;
        if (a > b)
            return 0;
        if (a == b) {
            counter[0] += 1;
            // System.out.println(counter[0]);
            return 1;
        }
        if (b % mul == 0) {
            // counter[0] += 1;
            return calcRec(a, b - add, mul, add, counter) + calcRec(a, b / mul, mul, add, counter);
        }
        // counter[0] += 1;
        return calcRec(a, b - add, mul, add, counter);
    }

    public static long calc(int a, int b, int mul, int add, long[] counter) {
        Boolean doneAdd = false;
        Boolean doneMul = false;
        int[] result = new int[b];
        for (int i = a; i < b; i++) {
            if (i + add == b) {
                doneAdd = true;
                result[i] += 1;
            }
            if (a / i == b) {
                doneMul = true;
                result[i] += 1;
            }
            if (i - add > a && i - add < b) {
                result[i] += 1;
            }
            if (i % mul == 0 && i / mul > a) {
                result[i] += 1;
            }
        }
        long resultSum = 0;
        if (doneAdd || doneMul) {
            for (int i = 0; i < result.length; i++) {
                resultSum += result[i];
            }
        }

        // int start = a;
        // int finish = b;
        // while (start < finish) {
        // if (a * mul < b) {
        // a /= mul;
        // counter[0] += 1;
        // }
        // }
        return resultSum;
    }

    public static long calcVar(int a, int b, int mul, int add, long[] counter) {
        Boolean doneAdd = false;
        Boolean doneMul = false;
        int[] result = new int[b];
        result[a] = 1;
        for (int i = a; i < b; i++) {
            if (i + add == b) {                 // if hit the number
                doneAdd = true;
                result[i] += result[i - add];
            }
            if (a * i == b) {                   // if hit the number
                doneMul = true;
                result[i] += result[i / mul];
            }
            if (i + add < b) {   
                result[i] += result[i - add];
            }
            if (i % mul == 0 && i * mul < b) {
                result[i] += result[i / mul];
            }
        }
        long resultSum = 0;
        if (doneAdd || doneMul) {
            for (int i = 0; i < result.length; i++) {
                resultSum += result[i];
            }
        }
        System.out.println(Arrays.toString(result));
        return resultSum;
    }
}
