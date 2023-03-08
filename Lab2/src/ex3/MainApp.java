package ex3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String str;
        Scanner scan = new Scanner(System.in);

        System.out.print("Introdu un string: ");
        str = scan.nextLine();

        StringBuilder strB = new StringBuilder(str);

        System.out.print("Introdu un alt string: ");
        str = scan.nextLine();
        int n;

        do {
            System.out.print("Introdu pozitia din care inserezi: ");
            n = scan.nextInt();
        } while(n >= str.length() || n < 0);

        System.out.println("Stringul nou : " + strB.insert(n, str));

        int m;
        do {
            System.out.print("Introdu pozitia din care incepi stergerea: ");
            n = scan.nextInt();
            System.out.print("Introdu pozitia in care se termina stergerea: ");
            m = scan.nextInt();
        } while((n >= str.length() || n < 0)
                && (m >= str.length() || m < 0));

        System.out.println("Stringul rezultat : " + strB.delete(n, m));
    }
}
