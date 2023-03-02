package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainApp {

    void afiseaza(String[] j) {
        for(String s: j){
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws IOException {
        String nume_fis = "judete_in.txt";

        String judete[];
        judete = new String[14];

        final int[] i = {0};
        Stream<String> lines =Files.lines(Path.of(nume_fis));
        lines.forEach(s -> {
            judete[i[0]] = s;
            i[0] += 1;
        });

        Arrays.sort(judete);

        Scanner scan = new Scanner(System.in);

        System.out.print("Introdu judetul pe care il cauti : ");
        String s = scan.nextLine();

        if(Arrays.asList(judete).contains(s)){
            System.out.println(s + "este pe pozitia : " + Arrays.binarySearch(judete, s));
        }
    }
}
