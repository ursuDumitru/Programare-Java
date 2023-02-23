package exercitiu1;

import java.util.Scanner;
public class MainApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu lungimea : ");
        int lung = scanner.nextInt();

        System.out.print("Introdu latimea : ");
        int lat = scanner.nextInt();

        System.out.println("Perimetrul acestui dreptungh este : " + (2*lung + 2*lat));
    }
}
