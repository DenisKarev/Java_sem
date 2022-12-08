package HW4;

public class HW4 {
    public static void printMap(int[][] mapa) {
        StringBuffer top = new StringBuffer("▒▒");
        for (int i = 0; i < mapa[0].length+1; i++) {
            top.append("▒▒");
        }
        System.out.println(top);
        for (int[] is : mapa) {
            printMapLine(is);
        }
        System.out.println(top);
    }
    
    public static void printMapLine(int[] array) {
        String wall = "▒▒";           // "█▓▒░"
        // System.out.printf("[ ");
        System.out.print(wall);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                System.out.print("▓▓");
            } else System.out.printf("%2d", array[i]);
        }
        // System.out.printf("%2d", array[array.length - 1]);
        System.out.print(wall);
        System.out.printf("\n");
    }
}
