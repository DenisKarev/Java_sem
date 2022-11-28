/*
+Реализовать функцию возведения числа а в степень b. a, b ∈ Z.
Сводя количество выполняемых действий к минимуму.
Пример 1: а = 3, b = 2, ответ: 9
Пример 2: а = 2, b = -2, ответ: 0.25
Пример 3: а = 3, b = 0, ответ: 1
Пример 4: а = 0, b = 0, ответ: не определено
Пример 5
входные данные находятся в файле input.txt в виде
b 3
a 10
Результат нужно сохранить в файле output.txt
1000
*/
package HW1;

// import java.util.Scanner;

public class Programm {
    public static void main(String[] args) {
        // Если лень вводить
        int a = 3;
        int b = 2;

        // Scanner s = new Scanner(System.in);
        // int a = HW1.consoleInputInt();
        // int b = HW1.consoleInputInt();
        // s.close();

        System.out.printf("a = %d, b = %d \n", a, b);
        double result = HW1.aPowB(a, b);
        HW1.printRes(a, b, result);
                
        int[] fromfile = HW1.fileInput();
        System.out.printf("a = %d, b = %d \n", fromfile[0], fromfile[1]);
        double fResult = HW1.aPowB(fromfile[0], fromfile[1]);
        System.out.printf("%d в степени %d = %f \n", fromfile[0], fromfile[1], fResult);
        HW1.fileOutput(fResult);

    }
}
