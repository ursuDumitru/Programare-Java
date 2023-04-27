package ex2;

/**
 * Clasa Pereche de Numere definita de Dumitru
 * */
public class PerecheNumere {
    private int x, y;

    public PerecheNumere() { }

    /**
     * Constructor definit de Dumitru
     * */
    public PerecheNumere(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    static int previousFibonacci(int n) {
        double a = n / ((1 + (int)Math.sqrt(5)) / 2.0);
        return (int)Math.round(a);
    }

    static int nextFibonacci(int n) {
        double a = n * (1 + (int)Math.sqrt(5)) / 2.0;
        return (int)Math.round(a);
    }

    static boolean isPerfectSquare(int x) {
        int s = (int)Math.sqrt(x);
        return (s * s == x);
    }

    static boolean isFibonacci(int n) {
        return (isPerfectSquare(5 * n * n + 4)
                || isPerfectSquare(5 * n * n - 4));
    }

    /**
     * Functie care returneaza true in cazul in care
     * numerele obiectului care apeleaza sunt numere
     * consecutive in sirul Fibbonacci
     * */
    boolean isConsecutiveFibbonaci(){
        if (isFibonacci(this.x) && isFibonacci(this.y)) {
            int prevFib = previousFibonacci(this.x);
            int nextFib = nextFibonacci(this.x);

            if (prevFib == this.y || nextFib == this.y) {
                return true;
            }
        }
        return false;
    }


    /**
     * Functie pentru determinarea celui mai mic
     * divizor comun a numerelor din obiectul
     * care apeleaza
     * */
    public int lcm() {
        if (this.x == 0 || this.y == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(this.x);
        int absNumber2 = Math.abs(this.y);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    private char[] intToChar(int nr) {
        return String.valueOf(nr).toCharArray();
    }

    private int charToInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    /**
     * Functie care returneaza true daca suma cifrelelor
     * numerelor obiectului apelant sunt egale si false in
     * caz contrar
     * */
    boolean sumaCifrelorEgala() {
        char[] cifreX = intToChar(this.x);
        char[] cifreY = intToChar(this.y);
        int i = 0, j = 0;

        for(var iX : cifreX){
            i+= charToInt(iX);
        }
        for(var iY : cifreX){
            j+= charToInt(iY);
        }

        return i == j;
    }

    /**
     * Functie care retuneaza true daca ambele
     * numere ake obiectului apelant au acelasi
     * numar de cifre pare
     * */
    boolean nrCifrePare() {
        char[] cifreX = intToChar(this.x);
        char[] cifreY = intToChar(this.y);
        int i = 0, j = 0;

        for(var iX : cifreX)
            if(charToInt(iX) % 2 == 0)
                i++;

        for(var iY : cifreX)
            if(charToInt(iY) % 2 == 0)
                j++;

        return i == j;
    }
}
