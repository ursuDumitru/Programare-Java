package App;

public class SistemDeCalcul extends Echipament {
    String tip_min;
    double vit_proc;
    int c_hdd;
    SistemeDeOperare sistemDeOperare;

    public SistemDeCalcul(String denumire, int nr_inv,
                          double pret, char zona_magaz,
                          Situatie.situatie situatie, String tip_min,
                          double vit_proc, int c_hdd,
                          SistemeDeOperare sistemDeOperare)
    {
        super(denumire, nr_inv, pret, zona_magaz, situatie);
        this.tip_min = tip_min;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemDeOperare = sistemDeOperare;
    }

    enum SistemeDeOperare { Windows, Linux }

    @Override
    public String toString() {
        return super.toString() +
                " ," + tip_min +
                " ," + vit_proc +
                " ," + c_hdd +
                " ," + sistemDeOperare.toString();
    }
}
