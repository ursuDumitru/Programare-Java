package ex2;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirarii;
    private static double Incasari = 0;

    public Produs(String denumire, double pret, int cantitate, LocalDate dataExpirarii) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirarii = dataExpirarii;
    }

    public static List<Produs> ListaProduse = new ArrayList<>();

    public static void showList(){

        if(ListaProduse.isEmpty()){
            System.out.println("\nLista goala!");
            return;
        }

        System.out.println("\n***********************************\n");
        for(Produs p : ListaProduse)
            System.out.println(p.toString());
        System.out.println("\n***********************************\n");

    }
    public static void readList() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("produse.csv"));
        String linie;

        while((linie = file.readLine()) != null && linie.length() != 0) {
            String[] date = linie.split(",");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            ListaProduse.add(new Produs(date[0], Double.parseDouble(date[1]),
                    Integer.parseInt(date[2]), LocalDate.parse(date[3],
                    formatter.withLocale( Locale.US ))));
        }

        file.close();
    }
    public LocalDate getDataExpirarii() {
        return dataExpirarii;
    }
    public String getDenumire() {
        return denumire;
    }
    public int getCantitate() {
        return cantitate;
    }
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
    public static double getIncasari() {
        return Incasari;
    }
    public static void setIncasari(double incasari) {
        Incasari = incasari;
    }
    public double getPret() {
        return pret;
    }
    public static void produseExpirate(){
        if(ListaProduse.isEmpty()){
            System.out.println("\nLista goala!");
            return;
        }

        System.out.println("\n***********************************\n");
        for(Produs p : ListaProduse)
            if(p.getDataExpirarii().isBefore(LocalDate.now()))
                System.out.println(p.toString());
        System.out.println("\n***********************************\n");
    }
    public static void vanzareProdus() {
        if(ListaProduse.isEmpty()){
            System.out.println("\nLista goala!");
            return;
        }

        System.out.print("\nIntrodu numele produsului pe care vrei sa il vinzi : ");
        String prod = new Scanner(System.in).nextLine(); //THIS WORKS
        boolean c = false;
        
        for(Produs p : ListaProduse)
            if(p.getDenumire().equals(prod)){
                c = true;
                System.out.print("\nIntrodu numarul de bucati : ");
                int buc = new Scanner(System.in).nextInt();

                if(p.getCantitate() >= buc) {
                    p.setCantitate(p.getCantitate() - buc);
                    double m = Produs.getIncasari() + buc * p.getPret();
                    Produs.setIncasari(m);
                    System.out.println("Incasari totale : " + Produs.getIncasari());

                    if(p.getCantitate() == 0) {
                        ListaProduse.remove(p);
                        return;
                    }
                }
                else {
                    System.out.println("Nu exista atatea bucati de " + p.getDenumire());
                    return;
                }
            }

        if(!c)
            System.out.println("\nNu exista asa produs!");
    }
    public static void preturiMinime() {
        if(ListaProduse.isEmpty()){
            System.out.println("\nLista goala!");
            return;
        }

        double min = Collections
                .min(ListaProduse, Comparator.comparing(Produs::getPret))
                .getPret();

        for(Produs p : ListaProduse){
            if(p.getPret() == min)
                System.out.println(p.toString());
        }
    }
    public static void cantitateMinima() throws IOException {
        if(ListaProduse.isEmpty()){
            System.out.println("\nLista goala!");
            return;
        }

        System.out.print("\nIntrodu o cantitate maxima : ");
        int max = new Scanner(System.in).nextInt();

        BufferedWriter fo = new BufferedWriter(new FileWriter("produse_out.txt"));

        for(Produs p : ListaProduse)
            if(p.getCantitate() <= max)
                fo.write(p.toString() + "\n");

        fo.close();
    }
    @Override
    public String toString(){
        return this.denumire + ", " + this.pret + ", " +
                this.cantitate + ", " + this.dataExpirarii.toString();
    }
}
class Meniu {
    public static void arataMeniu() throws IOException {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("\n***********************************\n" +
                    "0.\tIesire\n" +
                    "1.\tCitire din fisier\n" +
                    "2.\tAfisarea tuturor produselor din Lista\n" +
                    "3.\tAfisarea produselor expirate\n" +
                    "4.\tVanzarea unui produs\n" +
                    "5.\tAfisarea produselor cu pret minim\n" +
                    "6.\tSalvarea produselor cu o cantitate max. determinata\n" +
                    "***********************************\n" +
                    "\n\tIntrodu optiunea : ");
            alegereOptiune(scan.nextInt());
        }
    }

    public static void alegereOptiune(int opt) throws IOException {
        switch (opt){
            case 0:
                System.out.println("\n\nAi ales optiunea de iesire!");
                System.exit(0);
                break;
            case 1:
                Produs.readList();
                System.out.println("\nCitire  efectuata cu succes!");
                break;
            case 2:
                Produs.showList();
                break;
            case 3:
                Produs.produseExpirate();
                break;
            case 4:
                Produs.vanzareProdus();
                break;
            case 5:
                Produs.preturiMinime();
                break;
            case 6:
                Produs.cantitateMinima();
                break;
            default:
                System.out.println("Optiune necunoscuta!\n\n");
        }
    }
}

public class Main2 {
    public static void main(String[] args) throws IOException {
        Meniu.arataMeniu();
    }
}
