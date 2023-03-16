package App;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static public List<Echipament> ListaEchipamente = new ArrayList<>();
    public static void main(String[] args) {



        while(true){
            int opt = Meniu.afiseazaMeniu();

        }

    }
}

class Meniu {
    static public int afiseazaMeniu(){
        System.out.print("\b\t******************************************\n" +
                "0.\tCitire din Fisier" +
                "1.\tAfisarea tuturor Echipamentelor\n" +
                "2.\tAfisarea imprimantelor\n" +
                "3.\tAfisarea copiatoarelor\n" +
                "4.\tAfisarea sistemelor de calcul\n" +
                "5.\tModificarea starii in care se afla un echipament\n" +
                "6.\tSetarea unui anumit mod de scriere pentru o imprimanta\n" +
                "7.\tSetarea unui format de copiere pentru copiatoare\n" +
                "8.\tInstalara unui anumit sistem de operare pe sistemele de calcul\n" +
                "9.\tIesire" +
                "\b\t******************************************" +
                "\n\nintrodu optiunea ta : ");
        return new Scanner(System.in).nextInt();
    }

    static public void citireFisier() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("echipamente.txt"));

        String line;
        while((line = br.readLine()) != null && line != ""){
            String[] valori = line.split(";");

//            if(valori[5].equals(Imprimanta.class.getSimpleName())) // ESTE POSIBIL SI ASA

            switch (valori[5]){
                case "imprimanta":
                    Main.ListaEchipamente.add(new Imprimanta(valori[0],
                                                                Integer.parseInt(valori[1]),
                                                                Double.parseDouble(valori[2]),
                                                                valori[3].charAt(0),
                                                                Situatie.toSituatie(valori[4]),
                                                                Integer.parseInt(valori[6]),
                                                                valori[7],
                                                                Integer.parseInt(valori[8]),
                                                                Imprimanta.toModuriTiparire(valori[9])));
                    break;
                case "copiator": //HERE
            }
        }
    }

}
