package App;

public abstract class Echipament {
    String denumire;
    int nr_inv;
    double pret;
    char zona_magaz;
    Situatie.situatie situatie;

    public Echipament(){};
    public Echipament(String denumire, int nr_inv,
                       double pret, char zona_magaz, Situatie.situatie situatie)
    {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_magaz = zona_magaz;
        this.situatie = situatie;
    }

    @Override
    public String toString(){
        return denumire +
                " ," + nr_inv +
                " ," + pret +
                " ," + zona_magaz +
                " ," + this.situatie.toString();
    }
}
