/*
Урок 2. Почему вы не можете не использовать API
Реализовать алгоритм сортировки массива слиянием
*/
package HW2;

public class Programm {
    public static void main(String[] args) {
        int[] arr = new int[10];
        HW2.fillArrayInts(arr, -10, 10);
        System.out.println("Исходный массив:");
        HW2.printArrayInts(arr);
        HW2.sortMerge(arr, 0, arr.length-1);
        System.out.println("Отсортированый массив:");
        HW2.printArrayInts(arr);
    }
}
