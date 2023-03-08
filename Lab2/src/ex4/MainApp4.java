package ex4;

import java.lang.reflect.Array;
import java.util.*;

class Person{
    String nume, cnp;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    static Boolean checkCNP(String cnp){
        char[] chars = cnp.toCharArray();

        if(chars.length != 13)
            return false;

        for(char c : chars){
            if(!Character.isDigit(c))
                return false;
        }

        int lunaNasterii = Integer.parseInt(String.valueOf(chars[3])) * 10 +
                Integer.parseInt(String.valueOf(chars[4]));

        if(!(lunaNasterii <= 12 && lunaNasterii > 1))
            return false;

        int ziuaNasterii = Integer.parseInt(String.valueOf(chars[5])) * 10 +
                Integer.parseInt(String.valueOf(chars[6]));

        if(!(ziuaNasterii <= 31 && ziuaNasterii > 1))
            return false;

        int codulJudet = Integer.parseInt(String.valueOf(chars[7])) * 10 +
                Integer.parseInt(String.valueOf(chars[8]));

        if(!(codulJudet <= 52 && codulJudet > 1))
            return false;

        int cifraAleatoare = Integer.parseInt(String.valueOf(chars[9])) * 100 +
                Integer.parseInt(String.valueOf(chars[10])) * 10 +
                Integer.parseInt(String.valueOf(chars[11]));

        if(cifraAleatoare == 0)
            return false;

        int nrMagic = Integer.parseInt(cnp.substring(0, cnp.length() - 1));
        //IMPLEMENTEAZA Mai departe

        return true;
    }
}

public class MainApp4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Person> listaPersoane = new ArrayList<>();

        System.out.print("Introdu numarul de persoane : ");
        int nrPers = scan.nextInt();

        while(nrPers > 0){
            System.out.print("\nIntrodu numele persoanei : ");
            String nume = scan.nextLine();
            System.out.print("Introdu CNP-ul corect : ");
            String cnp = scan.nextLine();

            Person pers = new Person();
            listaPersoane.add(pers);
            nrPers--;
        }

    }
}
