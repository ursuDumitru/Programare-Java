package App;
public class Imprimanta extends Echipament{
    int ppm;
    String rezolutie;
    int p_car;
    ModuriTiparire modTiparire;
    enum ModuriTiparire { Color, AlbNegru, Necunoscut}

    public static ModuriTiparire toModuriTiparire(String s) {
        switch (s){
            case "color":
                return ModuriTiparire.Color;
            case "alb/negru":
                return ModuriTiparire.AlbNegru;
        }
        return ModuriTiparire.Necunoscut;
    }

    public Imprimanta(String denumire, int nr_inv, double pret,
                      char zona_magaz, Situatie.situatie situatie, int ppm,
                      String rezolutie, int p_car, ModuriTiparire modTiparire)
    {
        super(denumire, nr_inv, pret, zona_magaz, situatie);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.modTiparire = modTiparire;
    }

    @Override
    public String toString(){
        return super.toString() +
                " ," + ppm +
                " ," + rezolutie +
                " ," + p_car +
                " ," + modTiparire.toString();
    }
}
