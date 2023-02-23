package exercitiu5;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class MainApp {
    public static void main(String[] args) {
        int n1=0,n2=1,n3,i,count=10;
        int []fibb;
        fibb = new int[10];
        fibb[0] = 0;
        fibb[1] = 1;

        for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3=n1+n2;
            fibb[i] = n3;
            n1=n2;
            n2=n3;
        }

        Random ran = new Random();
        int nr = ran.nextInt(20);

        if(IntStream.of(fibb).anyMatch(x -> x == nr))
            System.out.println(nr + " Este un numar din sirul fibbonaci !");
        else
            System.out.println(nr + " Nu ste un numar din sirul fibbonaci !");
    }
}
