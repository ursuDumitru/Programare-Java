package main;

interface Vehicul{

    public void start();
    public void stop();
    public void run();
    public boolean isRunning();

}

abstract class Motor{

    protected float capacitate = 0;
    protected int putere = 0;
    private float consum = 0;

    public abstract void start();

    public void stop() {
        consum = 0;
    }

    public abstract void accelerate();

    protected void changeConsume(double deltaVal){
        consum += deltaVal;
    }

    public	float getConsum(){
        return consum;
    }
}



class MotorOtto extends Motor{
    private boolean isStarted;

    public void start() {
        isStarted = true;
    }

    public void stop(){
        super.stop();

        isStarted = false;
    }

    public void accelerate(){
        changeConsume(0.1);
    }
}

class MotorDiesel extends Motor{
    public void start(){
        makeSparks();
    }


    public void stop(){
        super.stop();
    }

    public void accelerate(){
        changeConsume(0.04);
        System.out.println("Accelerare Diesel");
    }

    private void makeSparks() {}
}

class Masina implements Vehicul{
    private Motor motor;
    private float capacitateRezervor;
    private float volumCurentRezervor;
    private boolean isRunning = false;

    public Masina(Motor m, float capacitate){
        capacitateRezervor = capacitate;
        volumCurentRezervor = capacitate;
        motor = m;
    }

    public void start(){
        motor.start();
        isRunning = true;
    }

    public void stop(){
        motor.stop();
        isRunning = false;
    }

    public void run(){
        motor.accelerate();

        volumCurentRezervor -= motor.getConsum();

        if(volumCurentRezervor <= 0)
            stop();
    }

    public boolean isRunning(){ return isRunning; }
}

public class Main {
    public static void main(String[] args){

        Masina masina = new Masina(new MotorOtto(), 20);

        masina.start();

        run_1000(masina);

        if(masina.isRunning())
            masina.stop();
    }

    private static void run_1000(Vehicul v){
        for(int i=0; i<10000 && v.isRunning(); i++)
            v.run();
    }
}
