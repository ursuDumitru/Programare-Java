package ex2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

class Vers{
    private String vers;
    public String ga;

    public Vers(String vers, String ga) {
        this.vers = vers;
        this.ga = ga;
    }

    public String getVers() {
        return vers;
    }

    int countWordsUsingSplit() {
        if (this.vers == null || this.vers.isEmpty()) {
            return 0;
        }
        String[] words = this.vers.split(" ");
        return words.length;
    }


    int count_vowels() {
        int count = 0;
        for (int i = 0; i < this.vers.length(); i++) {
            // check if char[i] is vowel
            if (this.vers.charAt(i) == 'a' || this.vers.charAt(i) == 'e'
                    || this.vers.charAt(i) == 'i'
                    || this.vers.charAt(i) == 'o'
                    || this.vers.charAt(i) == 'u') {
                count++;
            }
        }

        return count;
    }

    void add_info(){
        if(this.vers.endsWith(this.ga))
            this.vers = this.vers + "*";
        
        this.vers = this.vers + " ||  cuvinte : " + countWordsUsingSplit() //cuvinte nu litere
                + " vocale : " + count_vowels();



        Random ran = new Random();
        double x = (double)Math.abs(ran.nextInt())/Integer.MAX_VALUE;
        if(x < 0.1)
            this.vers.toUpperCase();
    }
}

public class MainApp {
    public static void main(String[] args) throws IOException {

        ArrayList<Vers> versuri = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String grupare_aleasa = scan.nextLine();

        Stream<String> lines = Files.lines(Path.of("cantec_in.txt"));
        lines.forEach(s -> { versuri.add(new Vers(s, grupare_aleasa)); });

        FileWriter out_file = new FileWriter("cantec_out.txt");
        for(Vers item : versuri) {
            item.add_info();
            out_file.write(item.getVers() + "\n");
        }
    }
}
