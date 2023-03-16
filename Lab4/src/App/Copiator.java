package App;

public class Copiator extends Echipament{
    int p_ton;
    FormateCopiere fromatCopiere;

    public Copiator(String denumire, int nr_inv,
                    double pret, char zona_magaz,
                    Situatie.situatie situatie, int p_ton,
                    FormateCopiere fromatCopiere)
    {
        super(denumire, nr_inv, pret, zona_magaz, situatie);
        this.p_ton = p_ton;
        this.fromatCopiere = fromatCopiere;
    }

    enum FormateCopiere { A3, A4 }

    @Override
    public String toString(){
        return super.toString() +
                " ," + p_ton +
                " ," + fromatCopiere.toString();
    }
}
