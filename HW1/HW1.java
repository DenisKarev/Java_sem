package HW1;

import java.util.Scanner;

import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileNotFoundException;


public class HW1 {
    public static void printRes(int a, int b, double res) {
        if (res == -1) {
            System.out.printf("\nРезультат %d в степени %d = %s\n", a, b, "Не определено");
        } else {
            System.out.printf("\nРезультат %d в степени %d = %s\n", a, b, String.valueOf(res));
        }
    }

    public static double aPowB(int a, int b) {
        double res = 1;
        if (a == 0 && b == 0) {
            res = -1;
        } else {
            if (b == 0)
                res = 1;
            else {
                if (b < 0) {
                    for (int i = 0; i < -b; i++) {
                        res *= a;
                    }
                    res = 1 / res;
                } else {
                    for (int i = 0; i < b; i++) {
                        res *= a;
                    }
                }
            }
        }
        return res;
    }

    public static int consoleInputInt() {
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter an integer: ");
            try {
                int num = s.nextInt();
                return num;
            } catch (Exception e) {
                // System.out.println(e);
                System.out.println("Wrong integer -- try again");
            }
        }
    }

    public static int[] fileInput() {
        String str = "";
        int[] resStr = new int[2];
        try {
            BufferedReader bufR = new BufferedReader(new FileReader("./HW1/input.txt"));
            while ((str = bufR.readLine()) != null) {
                if (str.startsWith("a ")) {
                    resStr[0] = Integer.parseInt(str.substring(2, str.length()));
                } else {
                    if (str.startsWith("b ")){
                        resStr[1] = Integer.parseInt(str.substring(2, str.length()));
                    }
                }
                System.out.printf("%s\n", str);
            }
            bufR.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return resStr;
    }

    public static void fileOutput(double powRes) {
        try (FileWriter bufW = new FileWriter("./HW1/output.txt", false)){
            bufW.write(String.valueOf(powRes));
            bufW.append('\n');
            bufW.flush();
            bufW.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}