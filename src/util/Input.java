package util;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String fetchInput(String text) {
        System.out.print(text.concat(" : "));
        return scanner.nextLine();
    }
}
