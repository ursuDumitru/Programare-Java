package exercitiu4;

import java.util.Random;

public class CMMDC {
    public static int cmmdc(int x, int y){
        while (y > 0)
        {
            int temp = y;
            y = x % y; // % is remainder
            x = temp;
        }
        return x;
    }
}

class Main{
    public static void main(String[] args) {
        Random ran = new Random();
        int x = ran.nextInt(30);
        int y = ran.nextInt(30);

        System.out.println("Cel mai mic divizior comun intre " + x + " si " + y + " este : " + CMMDC.cmmdc(x, y));
    }
}