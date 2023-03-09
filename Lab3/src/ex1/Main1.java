package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Parabola{
    int a, b, c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Coords coordonateleVarfului(){
        Coords coords = new Coords();
        coords.x = (float)this.b / ( 2 * this.a ) * -1;
        coords.y = (float)(this.b * this.b - 4 * this.a) / ( 4 + this.a ) * -1;

        return  coords;
    }
    @Override
    public String toString(){
        return a + "x^2 + " + "(" + b + ")x + " + "(" + c + ")";
    }
    public Coords mijloculSegDreapta(Parabola p2) {
        Coords cP1 = this.coordonateleVarfului();
        Coords cP2 = p2.coordonateleVarfului();
        Coords mijSegDr = new Coords();
        mijSegDr.x = (cP1.x + cP2.x) / 2;
        mijSegDr.y = (cP1.y + cP2.y) / 2;

        return mijSegDr;
    }
    static public Coords mijloculSegDreapta2(Parabola p1, Parabola p2) {
        Coords cP1 = p1.coordonateleVarfului();
        Coords cP2 = p2.coordonateleVarfului();
        Coords mijSegDr = new Coords();
        mijSegDr.x = (cP1.x + cP2.x) / 2;
        mijSegDr.y = (cP1.y + cP2.y) / 2;

        return mijSegDr;
    }
    double lungimeaSeg(Parabola p2){
        return Math.hypot((p2.coordonateleVarfului().x - this.coordonateleVarfului().x),
                (p2.coordonateleVarfului().y - this.coordonateleVarfului().y));
    }
    static double lungimeaSeg2(Parabola p1, Parabola p2){
        return Math.hypot((p2.coordonateleVarfului().x - p1.coordonateleVarfului().x),
                (p2.coordonateleVarfului().y - p1.coordonateleVarfului().y));
    }
}

class Coords{
    public float x;
    public float y;

    @Override
    public String toString() {
        return "( " + x + ", " + y + " )";
    }
}

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("in.txt"));
        ArrayList<Parabola> parabole = new ArrayList<>();

        String linie = "";
        while((linie = bf.readLine()) != null && linie.length() != 0) {
            String[] result = linie.split(" ");
            parabole.add(new Parabola(Integer.valueOf(result[0]),
                    Integer.valueOf(result[1]),
                    Integer.valueOf(result[2])));
        }

        System.out.println("Coordonatele mijlocului segmentului non-static : " +
                parabole.get(0).mijloculSegDreapta(parabole.get(1)).toString());
        System.out.println("Coordonatele mijlocului segmentului static : " +
                Parabola.mijloculSegDreapta2(parabole.get(0), parabole.get(1)).toString());
        System.out.println("Lungimea segmentului non-static : " +
                parabole.get(0).lungimeaSeg(parabole.get(1)));
        System.out.println("Lungimea segmentului static : " +
                Parabola.lungimeaSeg2(parabole.get(0), parabole.get(1)));

        int i = 5;
        Integer.toString(i);
    }
}
