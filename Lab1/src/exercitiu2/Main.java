package exercitiu2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.io.FileWriter;   // Import the FileWriter class
import java.lang.Double;

public class Main {
    public static void main(String[] args) throws IOException {
        String nume_fis="in.txt";
        BufferedReader flux_in;

        flux_in = new BufferedReader(new FileReader(nume_fis));

        int num[];
        num = new int[6];

        String nr;
        int i = 0;

        nr = flux_in.readLine();
        while(nr != null){
            num[i] = Integer.parseInt(nr);
            i++;
            nr = flux_in.readLine();
        }

        int sum = 0;
        for (int j: num) {
            sum+=j;
        }

        System.out.println("Suma numerelor din fisier : " + sum);

        double meda = Double.valueOf(sum) / Double.valueOf(num.length);
        System.out.println("Meadia aritmetica : " + meda);

        IntSummaryStatistics stat = Arrays.stream(num).summaryStatistics();
        int min = stat.getMin();
        int max = stat.getMax();
        System.out.println("Nr Min : " + min);
        System.out.println("Nr Max : " + max);

        FileWriter out_file = new FileWriter("out.txt");
        out_file.write("Suma : " + sum);
        out_file.write("\nMedia aritemtica : " + meda);
        out_file.write("\nVal minima : " + min);
        out_file.write("\nVal maxima : " + max);
        out_file.close();
    }
}
