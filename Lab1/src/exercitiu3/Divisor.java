package exercitiu3;

public class Divisor {
    static void findDivisors(int nr){
        int count = 0;

        for(int i = 1; i <= nr; i++){
            if(nr%i==0){
                count++;
                System.out.println("Divisor : " + i);
            }
        }

        if(count == 2)
            System.out.println("Numarul " + nr + " este prim");
    }
}

class Main{
    public static void main(String[] args) {
        Divisor.findDivisors(8);
    }
}
